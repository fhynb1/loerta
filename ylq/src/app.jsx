const profile = {
  name: '颜丽琴',
  gender: '女',
  age: '22岁',
  wechat: '15526459636',
  jobTime: '3年',
  target: '带货主播',
  city: '杭州',
  hello: 'HELLO',
};

const advantages = [
  '具备较强学习能力与自我驱动能力，能够在短时间内掌握新业务逻辑并快速落地执行',
  '结果导向思维明确，在直播实战中以转化率与GMV为核心目标推进工作',
  '具备团队协作与沟通协调能力，能够在多岗位配合中保持高效执行',
  '拥有多品类直播经验，适应能力强，面对不同产品可迅速拆解卖点并形成成交话术',
  '抗压能力强，能够在高节奏直播环境中稳定输出并持续优化表现',
  '具备较强的用户洞察能力，善于挖掘痛点并提升流量价值',
];

const workExperience = [
  {
    company: '湖南柏晶文化有限公司',
    role: '主播',
    period: '2024.11-2025.12',
    content: [
      '负责直播间出镜销售公司瘦身减肥类产品，围绕身材管理、效果周期、成分优势及用户痛点进行结构化讲解，提升成交转化',
      '具备多品类带货能力，能够根据不同产品属性快速重构卖点与话术逻辑',
      '曾接手减肥食品、猪蹄类熟食、女性私护产品、进口牙膏等多个项目直播',
      '针对功能型产品强化“痛点放大 + 场景代入 + 消疑拆解 + 逼单成交”节奏',
      '能根据品类差异调整直播风格与用户沟通方式，提高信任感与复购潜力',
    ],
    achievements: ['月均UV', '月完成GSV', '转化率UV价值第一'],
  },
  {
    company: '湖南亦游国际旅行社有限公司',
    role: '主播',
    period: '2024.07-2024.11',
    content: [
      '直播销售旅游产品，负责全流程讲解与成交转化',
      '实地踩点目的地，输出专业旅游攻略及直播素材',
      '将真实体验转化为信任背书，增强用户决策信心',
      '根据不同客群拆解行程亮点，强化场景化种草与逼单成交',
    ],
  },
  {
    company: '西子健康',
    role: '主播',
    period: '2023.11-2024.06',
    content: [
      '11月入职，系统接受直播电商运营培训，熟练掌握直播带货完整成交逻辑，包括痛点挖掘、卖点提炼、福利设计、消疑拆解及逼单转化',
      '能独立完成直播脚本策划与节奏设计，具备较强的现场控场与成交能力',
      '单场最高承接在线人数105人，互动与留存表现稳定',
      '团队5名主播中，转化率长期稳居前3，连续3个月排名第1',
      'GMV持续保持团队前三',
      '个人单日最高GMV达10W+，单月最高GMV达50W+',
      '后期转入古本日记奶昔直播间，快速适应不同产品类型，具备跨品类带货能力，能够根据产品特性调整话术结构与成交策略，实现持续增长',
    ],
    achievements: ['直播间转化率前2', 'GMV 前二（直播间5人）'],
  },
];

const projectExperience = [
  {
    title: '芊屿芊浔美甲美睫',
    role: '主播',
    period: '2023.08-2023.11',
    content: [
      '担任主播一职责，每天基本上播2小时，主要负责直播带货，合计上播80个小时，合计GMV49W',
      '配合短视频出镜拍摄直播间引流视频',
      '策划和编写直播脚本',
      '在这些项目经历中对直播行业中的主播一职基本有了一个基本的了解，对直播流程基本了解，并且能够熟练直播后台操作，经此训练，能够自然的面对镜头，独立上播，不怯场，直播时也能保持思路清晰，能够快速解答粉丝疑问，引导购买，同时我也能很好的挖掘产品卖点，策划脚本，自己独立产出脚本共计10个，并做到后期直播时在脚本和话术中灵活应变，项目直播也取得了最高GMV达4W+的优异成绩',
    ],
  },
];

const education = {
  school: '湖南工商大学',
  degree: '本科',
  major: '电子商务',
  period: '2021-2024',
  rank: '专业排名：前1%',
  courses: [
    '电子商务概论',
    '电子商务',
    '市场营销',
    '管理学',
    '消费者行为学',
    '店铺运营基础',
    '淘宝运营进阶',
    '计算机基础',
    '淘宝直播',
    'PS 设计',
    'PR 剪辑',
    '新媒体运营',
    '数据分析',
    '跨境电商',
    '短视频运营',
    '直播营销与运营',
  ],
  honors: [
    '优秀班委',
    '优秀学生干部',
    '军训标兵',
    '三好学生',
    '三等奖奖学金',
  ],
};

function App() {
  return (
    <main className="resume-app">
      <div className="ambient ambient-left" aria-hidden="true" />
      <div className="ambient ambient-right" aria-hidden="true" />

      <header className="topbar">
        <a className="brand" href="#top" aria-label="返回顶部">
          YLQ
        </a>
        <nav className="nav-links" aria-label="页面导航">
          <a href="#advantage">优势</a>
          <a href="#experience">经历</a>
          <a href="#project">项目</a>
          <a href="#education">教育</a>
        </nav>
      </header>

      <section className="hero" id="top">
        <div className="hero-copy">
          <div className="live-badge">主播感简历页 · 带货主播档案</div>
          <p className="title" style={{ marginTop: '18px' }}>
            {profile.hello}
          </p>
          <h1>{profile.name}</h1>
          <p className="title">
            {profile.gender} | {profile.age}
          </p>
          <p className="summary">
            工作时长：{profile.jobTime} · 求职意向：{profile.target} · 期望城市：
            {profile.city}
          </p>

          <div className="highlights">
            <div className="highlight-card">
              <span>联系方式</span>
              <strong>微信号 {profile.wechat}</strong>
            </div>
            <div className="highlight-card">
              <span>求职信息</span>
              <strong>{profile.target}</strong>
            </div>
            <div className="highlight-card">
              <span>城市</span>
              <strong>{profile.city}</strong>
            </div>
            <div className="highlight-card">
              <span>状态</span>
              <strong>可快速上播</strong>
            </div>
          </div>

          <div className="hero-actions">
            <a className="primary-action" href="#experience">
              看直播经历
            </a>
            <a className="secondary-action" href={`tel:${profile.wechat}`}>
              直接联系
            </a>
          </div>
        </div>

        <aside className="profile-panel">
          <div className="avatar-wrap">
            <img
              className="avatar"
              src={avatarImage}
              alt="颜丽琴头像"
              style={{ objectFit: 'cover' }}
            />
            <div className="live-signal">
              <span className="dot" />
              LIVE
            </div>
          </div>

          <div className="profile-copy">
            <strong>{profile.name}</strong>
            <span>
              {profile.gender} | {profile.age}
            </span>
          </div>

          <ul className="contact-list">
            <li>微信号：{profile.wechat}</li>
            <li>求职意向：{profile.target}</li>
            <li>期望城市：{profile.city}</li>
          </ul>

          <div className="panel-note">我有三年带货直播经验，希望能够合作</div>
        </aside>
      </section>

      <section className="section" id="advantage">
        <div className="section-heading">
          <p>Personal Advantage</p>
          <h2>个人优势</h2>
        </div>
        <div className="feature-grid">
          {advantages.map((item, index) => (
            <article className="feature-card" key={item}>
              <div className="feature-icon">
                {String(index + 1).padStart(2, '0')}
              </div>
              <h3>优势 {index + 1}</h3>
              <p>{item}</p>
            </article>
          ))}
        </div>
      </section>

      <section className="section" id="experience">
        <div className="section-heading">
          <p>Work Experience</p>
          <h2>工作经历</h2>
        </div>
        <div className="timeline">
          {workExperience.map((job) => (
            <article className="timeline-item" key={`${job.company}-${job.period}`}>
              <div className="timeline-icon">播</div>
              <div>
                <span>
                  {job.company} · {job.role} · {job.period}
                </span>
                <h3>{job.company}</h3>
                <p style={{ marginTop: '10px' }}>内容：</p>
                <ul className="detail-list">
                  {job.content.map((line) => (
                    <li key={line}>{line}</li>
                  ))}
                </ul>
                {job.achievements ? (
                  <>
                    <p style={{ marginTop: '10px' }}>业绩：</p>
                    <div className="mini-tags">
                      {job.achievements.map((tag) => (
                        <span key={tag}>{tag}</span>
                      ))}
                    </div>
                  </>
                ) : null}
              </div>
            </article>
          ))}
        </div>
      </section>

      <section className="section" id="project">
        <div className="section-heading">
          <p>Project Experience</p>
          <h2>项目经历</h2>
        </div>
        <div className="project-grid">
          {projectExperience.map((project, index) => (
            <article className={`project-card tone-${(index % 3) + 1}`} key={project.title}>
              <span>
                {project.role} · {project.period}
              </span>
              <h3>{project.title}</h3>
              <div className="project-content">
                {project.content.map((line) => (
                  <p key={line}>{line}</p>
                ))}
              </div>
            </article>
          ))}
        </div>
      </section>

      <section className="section" id="education">
        <div className="section-heading">
          <p>Education</p>
          <h2>教育经历</h2>
        </div>
        <article className="contact-band">
          <div>
            <p>{education.school}</p>
            <h2>
              {education.degree} · {education.major} · {education.period}
            </h2>
            <p className="section-subtitle">{education.rank}</p>
          </div>
          <div className="contact-actions">
            <div className="mini-tags">
              {education.honors.map((honor) => (
                <span key={honor}>{honor}</span>
              ))}
            </div>
          </div>
        </article>
        <div className="skill-grid" style={{ marginTop: '16px' }}>
          {education.courses.map((course) => (
            <span key={course}>{course}</span>
          ))}
        </div>
      </section>
    </main>
  );
}

export default App;
import avatarImage from './image/ylq.jpg';
