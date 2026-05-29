import {
  ArrowUpRight,
  BriefcaseBusiness,
  GraduationCap,
  Mail,
  MapPin,
  Phone,
  Sparkles,
} from 'lucide-react';

const profile = {
  name: '方浩宇',
  role: '运维工程师 / Linux ',
  location: '杭州',
  email: 'f19856610561@163.com',
  phone: '19856610561',
  wechat: '19856610561',
  summary:
    '具备 2 年运维经验，熟悉 Linux 发行版及国产麒麟操作系统，能够完成服务器环境部署、巡检监控、故障排查、数据库运维与中间件配置。擅长 Shell 脚本、Nginx、Redis、JDK、Docker、SQL 调优及项目交付支撑。',
};

const skills = [
  'Linux',
  '麒麟操作系统',
  'Shell',
  'Nginx',
  'Redis',
  'JDK',
  'Docker',
  'K8s 基础',
  'TCP/IP',
  'Oracle',
  'MySQL',
  '达梦数据库',
  'SQL 调优',
  'MQ 巡检',
  'AI 工具',
];

const projects = [
  {
    title: '新一代电网调度系统-水电',
    tag: '国调统推项目 · 项目参与 · 2025.06-2026.06',
    description:
      '负责电厂及华中网调通信程序部署调试、数据计算程序部署、数据库配置与数据迁移、触发器及索引重建、监视系统页面组态，并维护 Nginx、Nacos 等中间件，配合地调联调测试。',
  },
  {
    title: '全流域发电计划编制系统',
    tag: '开发实施项目 · 项目参与 · 2024.07-至今',
    description:
      '负责系统在电网本部服务器部署上线，搭建离线服务器环境，完成 Nginx、Redis、JDK 等中间件安装配置，支撑运行调试、客户需求对接、部署文档编写与项目验收。',
  },
  {
    title: '财税库银及税银系统运维',
    tag: '神州数码信息服务 · 实习项目 · 2023.06-2024.04',
    description:
      '面向省内地市、县区税务局处理业务问题，分析报文数据及交易日志，监控前置 MQ 服务器运行状态，协助系统升级上线验证并输出日常、月度巡检报告。',
  },
];

const timeline = [
  {
    icon: BriefcaseBusiness,
    period: '2024.08 - 至今',
    title: '运维工程师 · 江苏信鸿科技有限公司',
    text: '驻厂湖南电网，负责电网调度系统 7x24 小时运行保障、多台 Linux 服务器巡检维护、CPU/内存/磁盘及应用状态监控、业务运维问题处理、数据库管理优化、故障根因定位及项目验收支撑。',
  },
  {
    icon: BriefcaseBusiness,
    period: '2023.06 - 2024.04',
    title: '系统运维实习生 · 神州数码信息服务股份有限公司',
    text: '负责税务局业务问题排查处理，分析报文与交易日志，参与财税库银及税银系统巡检、版本升级、上线验证、银行及税局业务测试和 MQ 服务器监控。',
  },
  {
    icon: GraduationCap,
    period: '2020 - 2024',
    title: '软件工程 本科 · 安徽信息工程学院',
    text: '主修 C 语言、C++、C#、数据结构、数据库设计、软件工程、计算机组成原理、软件测试、前端模块化开发设计等课程。',
  },
];

function App() {
  return (
    <main className="page-shell">
      <nav className="topbar" aria-label="主导航">
        <a className="brand" href="#top" aria-label="返回顶部">
          FHY
        </a>
        <div className="nav-links">
          <a href="#skills">技能</a>
          <a href="#projects">项目</a>
          <a href="#experience">经历</a>
          <a href="#contact">联系</a>
        </div>
      </nav>

      <section className="hero" id="top">
        <div className="hero-copy">
          <span className="eyebrow">
            <Sparkles size={16} />
            2 年运维经验 · 求职意向：运维工程师
          </span>
          <h1>{profile.name}</h1>
          <p className="role">{profile.role}</p>
          <p className="summary">{profile.summary}</p>
          <div className="hero-actions">
            <a className="primary-action" href="#projects">
              查看项目
              <ArrowUpRight size={18} />
            </a>
            <a className="secondary-action" href={`mailto:${profile.email}`}>
              联系我
            </a>
          </div>
        </div>

        <aside className="profile-panel" aria-label="个人信息">
          <div className="avatar" aria-hidden="true">
            {profile.name.slice(0, 1)}
          </div>
          <div>
            <strong>{profile.name}</strong>
            <span>{profile.role}</span>
          </div>
          <ul>
            <li>
              <MapPin size={17} />
              期望城市：{profile.location}
            </li>
            <li>
              <Mail size={17} />
              {profile.email}
            </li>
            <li>
              <Phone size={17} />
              电话 / 微信：{profile.phone}
            </li>
          </ul>
        </aside>
      </section>

      <section className="section" id="skills">
        <div className="section-heading">
          <p>Operations Stack</p>
          <h2>技能栈</h2>
        </div>
        <div className="skill-grid">
          {skills.map((skill) => (
            <span key={skill}>{skill}</span>
          ))}
        </div>
      </section>

      <section className="section" id="projects">
        <div className="section-heading">
          <p>Selected Projects</p>
          <h2>项目经历</h2>
        </div>
        <div className="project-grid">
          {projects.map((project) => (
            <article className="project-card" key={project.title}>
              <span>{project.tag}</span>
              <h3>{project.title}</h3>
              <p>{project.description}</p>
            </article>
          ))}
        </div>
      </section>

      <section className="section two-column" id="experience">
        <div className="section-heading">
          <p>Career Path</p>
          <h2>工作与教育</h2>
        </div>
        <div className="timeline">
          {timeline.map((item) => {
            const Icon = item.icon;
            return (
              <article className="timeline-item" key={item.title}>
                <div className="timeline-icon">
                  <Icon size={20} />
                </div>
                <div>
                  <span>{item.period}</span>
                  <h3>{item.title}</h3>
                  <p>{item.text}</p>
                </div>
              </article>
            );
          })}
        </div>
      </section>

      <section className="contact-band" id="contact">
        <div className="footer-center">
          <h6>底部</h6>
        </div>
      </section>
    </main>
  );
}

export default App;
