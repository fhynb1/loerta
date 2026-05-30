package com.example.excel.customer;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/records")
public class CustomerRecordController {

    private static final String[] HEADERS = {
            "日期", "姓名", "电话", "年龄", "项目内容", "操作手", "针剂医生", "针剂接待", "成交总额", "医生手工", "护士手工"
    };

    private final CustomerRecordService service;

    public CustomerRecordController(CustomerRecordService service) {
        this.service = service;
    }

    @GetMapping
    public List<CustomerRecord> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CustomerRecord get(@PathVariable Long id) {
        return service.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "记录不存在"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerRecord create(@RequestBody CustomerRecord record) {
        validate(record);
        return service.save(record);
    }

    @PutMapping("/{id}")
    public CustomerRecord update(@PathVariable Long id, @RequestBody CustomerRecord record) {
        validate(record);
        boolean updated = service.update(id, record);
        if (!updated) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "记录不存在");
        }
        return service.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "记录不存在"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        if (!deleted) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "记录不存在");
        }
    }

    @GetMapping("/export")
    public void export(@RequestParam(required = false) List<Long> ids, HttpServletResponse response) throws IOException {
        List<CustomerRecord> records = ids == null || ids.isEmpty() ? service.findAll() : service.findByIds(ids);

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("表单数据");
            CreationHelper creationHelper = workbook.getCreationHelper();

            CellStyle headerStyle = workbook.createCellStyle();
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerStyle.setFont(headerFont);

            CellStyle dateStyle = workbook.createCellStyle();
            dateStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-mm-dd"));

            CellStyle moneyStyle = workbook.createCellStyle();
            moneyStyle.setDataFormat(creationHelper.createDataFormat().getFormat("#,##0.00"));

            Row header = sheet.createRow(0);
            for (int i = 0; i < HEADERS.length; i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(HEADERS[i]);
                cell.setCellStyle(headerStyle);
            }

            for (int i = 0; i < records.size(); i++) {
                Row row = sheet.createRow(i + 1);
                CustomerRecord record = records.get(i);
                writeDateCell(row, 0, record.getRecordDate(), dateStyle);
                writeStringCell(row, 1, record.getName());
                writeStringCell(row, 2, record.getPhone());
                writeNumberCell(row, 3, record.getAge());
                writeStringCell(row, 4, record.getProjectContent());
                writeStringCell(row, 5, record.getOperator());
                writeStringCell(row, 6, record.getInjectionDoctor());
                writeStringCell(row, 7, record.getInjectionReceptionist());
                writeMoneyCell(row, 8, record.getTotalAmount(), moneyStyle);
                writeMoneyCell(row, 9, record.getDoctorFee(), moneyStyle);
                writeMoneyCell(row, 10, record.getNurseFee(), moneyStyle);
            }

            for (int i = 0; i < HEADERS.length; i++) {
                sheet.autoSizeColumn(i);
                sheet.setColumnWidth(i, Math.min(sheet.getColumnWidth(i) + 512, 12000));
            }

            String filename = URLEncoder.encode("表单数据.xlsx", StandardCharsets.UTF_8).replace("+", "%20");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + filename);
            workbook.write(response.getOutputStream());
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleBadRequest(IllegalArgumentException exception) {
        return Map.of("message", exception.getMessage());
    }

    private void validate(CustomerRecord record) {
        if (record.getRecordDate() == null) {
            throw new IllegalArgumentException("日期不能为空");
        }
        if (isBlank(record.getName())) {
            throw new IllegalArgumentException("姓名不能为空");
        }
        if (isBlank(record.getPhone())) {
            throw new IllegalArgumentException("电话不能为空");
        }
        if (record.getAge() != null && (record.getAge() < 0 || record.getAge() > 150)) {
            throw new IllegalArgumentException("年龄需要在 0 到 150 之间");
        }
        if (isNegative(record.getTotalAmount()) || isNegative(record.getDoctorFee()) || isNegative(record.getNurseFee())) {
            throw new IllegalArgumentException("金额不能小于 0");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private boolean isNegative(BigDecimal value) {
        return value != null && value.signum() < 0;
    }

    private void writeStringCell(Row row, int index, String value) {
        row.createCell(index).setCellValue(value == null ? "" : value);
    }

    private void writeNumberCell(Row row, int index, Integer value) {
        if (value != null) {
            row.createCell(index).setCellValue(value);
        }
    }

    private void writeMoneyCell(Row row, int index, BigDecimal value, CellStyle style) {
        if (value != null) {
            Cell cell = row.createCell(index);
            cell.setCellValue(value.doubleValue());
            cell.setCellStyle(style);
        }
    }

    private void writeDateCell(Row row, int index, LocalDate value, CellStyle style) {
        if (value != null) {
            Cell cell = row.createCell(index);
            Date date = Date.from(value.atStartOfDay(ZoneId.systemDefault()).toInstant());
            cell.setCellValue(date);
            cell.setCellStyle(style);
        }
    }
}
