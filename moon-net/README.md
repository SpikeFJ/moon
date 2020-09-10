# 通讯连接层

通讯连接层主要管理客户端连接，心跳（客户端连接包括：设备连接、用户连接）


项目单独部署，独立运行，对外暴露哪些设备/用户在本通道上

但是集群部署后，需要有一个服务：获取每个设备/通道在具体的哪台机器上

之前是在客户端实现，这个是否应该放在服务端？

--------------客户端实现：--------------------

channel1--------------------channel2-----------------channel3
\                               |
 \                              |
  \

    client:查询系统所有的通道，一次发送请求，请求每个channel上的设备/用户，并缓存。




--------------服务端实现：----------------------

服务端实现：

Server:所有channel启动时，主动向server注册，且每次有连接变动时，主动通知server，Server保存设备与channel的关系
 |   \
 |    \
 |     \
 |       channel1--------------------channel2-----------------channel3
 |
 |
 |____client:客户端和Server通讯，获取所有在线设备及所处机器


客户端实现的优点
1. 少了server层，减少额外路径
2. 客户端可以根据自身业务要求主动控制获取频率

缺点:
1. 实时性不够，不同的客户端不能消息一致（如果采用消息中间件，channel作为生产者，client作为消费者也是可以做到实时通知的）


服务端的优点：
1. 实时通知
2. Server端可以针对原始数据进一步进行封装，
如原始数据就是Map<IpAndPort,Channel>,Server端可以针对具体业务提供Map<String/**地址**/,Channel>或其他

缺点：
1.增加系统复杂度

