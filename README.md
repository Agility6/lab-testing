## Lab-Testing 🧪

Lab-Testing 是一个用于汇总和验证后端常用技术的实验项目，旨在为技术验证和实验提供一个灵活的测试平台。通过搭建此项目，可以快速验证不同技术的可行性，并探索它们在实际场景中的表现。

### 项目结构:

#### framework 模块 

- 存放项目中所有与技术相关的子模块,模块代表不同的技术实现或功能组件。

#### core 模块

- 作为所有子模块的基础依赖。 提供项目核心功能或通用功能，各个子模块都依赖于`core module`，以确保模块间共享核心工具和功能。

### 项目工具和版本

- **Java 版本**: 1.8
- **Maven 编译设置**:
    - `project.build.sourceEncoding`: UTF-8
    - `project.reporting.outputEncoding`: UTF-8
    - `maven.compiler.compilerVersion`: 1.8
    - `maven.compiler.source`: 1.8
    - `maven.compiler.target`: 1.8

### 依赖工具及版本

- **Druid**: 1.1.10
- **MySQL Connector**: 8.0.11
- **MyBatis Plus**: 3.3.2
- **Velocity**: 2.3
- **Jackson**: 2.9.8
- **Guava**: 20.0
- **Commons Lang3**: 3.5
- **Commons Collections**: 3.2.1
- **FastJSON**: 1.2.56
- **JJWT** (JSON Web Token): 0.7.0
- **Commons IO**: 2.4
- **Swagger2**: 2.8.0
- **Swagger2 UI**: 1.9.3
- **Hutool**: 4.5.18
- **Reflections**: 0.9.10
- **MapStruct**: 1.5.2.Final
- **Caffeine**: 2.8.1
- **Project Lombok**: 1.18.20
- **Lombok MapStruct Binding**: 0.2.0