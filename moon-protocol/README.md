规约层主要提供下面几种服务

1. 组帧

  用户传入代表不同规约、数据项的json字符串，服务返回对应的字节数组

2. 解帧

  - 正常模式：用户传入字节数组，服务返回对应的json对象
  - 调试模式：用户传入字节数组，服务返回详细的json对象，包括每个json属性/对象 对应的字节序号


规约层抽取成单独的服务有以下好处：
1. 通讯协议相关的代码做到职责分离，
2. 可以实现跨语言通讯，协议可以做到真正的重用
3. 规约层是无状态的，可以方便集群部署

=============================
### 1. 如何快速新增一个协议

理想状态下，新建一个dll/jar，实现protocol接口(能否支持多语言开发，java的jar，net的dll，统一对外暴露服务）
打包部署，程序能够动态加载

可以参考dubbo的插件实现


### 2. 如何快速扩展一个已有协议


### 3. 如何调用
http最方便，集成springboot即可
后续可以考虑socket支持

调用方调用方法时是否需要显式的指定某个规约？
如制定DLT2007还是DLT1997

1. 解帧不要，调用方正常情况下也不知道自己是什么规约，只知道有一组byte数组。
2. 组帧需要

### 4. 如何匹配正确的规约

1. 依次尝试
2. 每种规约提供方法判断字节数组是否属于该规约