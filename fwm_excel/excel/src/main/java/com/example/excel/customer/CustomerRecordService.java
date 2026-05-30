package com.example.excel.customer;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerRecordService {

    private final JdbcTemplate jdbcTemplate;

    public CustomerRecordService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void createTableIfNeeded() {
        jdbcTemplate.execute("""
                CREATE TABLE IF NOT EXISTS customer_records (
                    id BIGINT PRIMARY KEY AUTO_INCREMENT,
                    record_date DATE NOT NULL,
                    name VARCHAR(100) NOT NULL,
                    phone VARCHAR(30) NOT NULL,
                    age INT NULL,
                    project_content VARCHAR(1000) NULL,
                    operator_name VARCHAR(100) NULL,
                    injection_doctor VARCHAR(100) NULL,
                    injection_receptionist VARCHAR(100) NULL,
                    total_amount DECIMAL(12, 2) NULL,
                    doctor_fee DECIMAL(12, 2) NULL,
                    nurse_fee DECIMAL(12, 2) NULL,
                    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
                )
                """);
    }

    public CustomerRecord save(CustomerRecord record) {
        jdbcTemplate.update("""
                INSERT INTO customer_records (
                    record_date, name, phone, age, project_content, operator_name,
                    injection_doctor, injection_receptionist, total_amount, doctor_fee, nurse_fee
                ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """,
                record.getRecordDate(),
                record.getName(),
                record.getPhone(),
                record.getAge(),
                record.getProjectContent(),
                record.getOperator(),
                record.getInjectionDoctor(),
                record.getInjectionReceptionist(),
                record.getTotalAmount(),
                record.getDoctorFee(),
                record.getNurseFee());
        return findLatest();
    }

    public List<CustomerRecord> findAll() {
        return jdbcTemplate.query("""
                SELECT id, record_date, name, phone, age, project_content, operator_name,
                       injection_doctor, injection_receptionist, total_amount, doctor_fee,
                       nurse_fee, created_at
                FROM customer_records
                ORDER BY record_date DESC, id DESC
                """, new CustomerRecordRowMapper());
    }

    public Optional<CustomerRecord> findById(Long id) {
        List<CustomerRecord> records = jdbcTemplate.query("""
                SELECT id, record_date, name, phone, age, project_content, operator_name,
                       injection_doctor, injection_receptionist, total_amount, doctor_fee,
                       nurse_fee, created_at
                FROM customer_records
                WHERE id = ?
                """, new CustomerRecordRowMapper(), id);
        return records.stream().findFirst();
    }

    public List<CustomerRecord> findByIds(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return List.of();
        }
        String placeholders = String.join(",", java.util.Collections.nCopies(ids.size(), "?"));
        String sql = """
                SELECT id, record_date, name, phone, age, project_content, operator_name,
                       injection_doctor, injection_receptionist, total_amount, doctor_fee,
                       nurse_fee, created_at
                FROM customer_records
                WHERE id IN (%s)
                ORDER BY record_date DESC, id DESC
                """.formatted(placeholders);
        return jdbcTemplate.query(sql, new CustomerRecordRowMapper(), ids.toArray());
    }

    public boolean update(Long id, CustomerRecord record) {
        int rows = jdbcTemplate.update("""
                UPDATE customer_records
                SET record_date = ?,
                    name = ?,
                    phone = ?,
                    age = ?,
                    project_content = ?,
                    operator_name = ?,
                    injection_doctor = ?,
                    injection_receptionist = ?,
                    total_amount = ?,
                    doctor_fee = ?,
                    nurse_fee = ?
                WHERE id = ?
                """,
                record.getRecordDate(),
                record.getName(),
                record.getPhone(),
                record.getAge(),
                record.getProjectContent(),
                record.getOperator(),
                record.getInjectionDoctor(),
                record.getInjectionReceptionist(),
                record.getTotalAmount(),
                record.getDoctorFee(),
                record.getNurseFee(),
                id);
        return rows > 0;
    }

    public boolean delete(Long id) {
        return jdbcTemplate.update("DELETE FROM customer_records WHERE id = ?", id) > 0;
    }

    private CustomerRecord findLatest() {
        return jdbcTemplate.queryForObject("""
                SELECT id, record_date, name, phone, age, project_content, operator_name,
                       injection_doctor, injection_receptionist, total_amount, doctor_fee,
                       nurse_fee, created_at
                FROM customer_records
                ORDER BY id DESC
                LIMIT 1
                """, new CustomerRecordRowMapper());
    }

    private static class CustomerRecordRowMapper implements RowMapper<CustomerRecord> {

        @Override
        public CustomerRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
            CustomerRecord record = new CustomerRecord();
            record.setId(rs.getLong("id"));
            record.setRecordDate(rs.getDate("record_date").toLocalDate());
            record.setName(rs.getString("name"));
            record.setPhone(rs.getString("phone"));
            int age = rs.getInt("age");
            record.setAge(rs.wasNull() ? null : age);
            record.setProjectContent(rs.getString("project_content"));
            record.setOperator(rs.getString("operator_name"));
            record.setInjectionDoctor(rs.getString("injection_doctor"));
            record.setInjectionReceptionist(rs.getString("injection_receptionist"));
            record.setTotalAmount(rs.getBigDecimal("total_amount"));
            record.setDoctorFee(rs.getBigDecimal("doctor_fee"));
            record.setNurseFee(rs.getBigDecimal("nurse_fee"));
            Timestamp createdAt = rs.getTimestamp("created_at");
            record.setCreatedAt(createdAt == null ? null : createdAt.toLocalDateTime());
            return record;
        }
    }
}
