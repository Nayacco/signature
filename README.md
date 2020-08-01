# HTTP请求签名校验机制

## 校验机制

1. 客户端和服务端双方通过某种方式约定一个只有双方知道的`secretKey`
2. 客户端将HTTP请求的`URL`、`METHOD`、`Request Parameter`、`Request Body` 用`secretKey`进行 `HmacSHA256` 签名，并附在请求参数里，传给服务端
3. 服务端收到请求后，获取请求的`URL`、`METHOD`、`Request Parameter`、`Request Body`，同样用`secretKey`进行 `HmacSHA256` 签名，比较客户端传过来的签名和服务端自己计算的签名是否一致，如果一致，则校验通过

另外：

1. 为了防止重放攻击，可以要求客户端传入的参数里必须包含时间戳，服务端校验时间戳过期则拒绝
2. 为了识别客户端身份，以及获取客户端对应的`secretKey`，可以要求客户端必须传入客户端ID
3. 客户端计算签名后，需要将签名附在请求参数里

所以，一个可能的设计是，客户端必须传入三个参数：s (签名) t （时间戳） d（设备ID）

## 配置

### 客户端配置

```
<dependency>
    <groupId>com.htnova</groupId>
    <artifactId>signature-client</artifactId>
    <version>1.1.1</version>
</dependency>
```

客户端使用方法：

```
String sign = SignatureClient.getInstance("112233").sign("GET", url);
String sign = SignatureClient.getInstance("112233").sign("POST", url,body);
```

参考：SignatureApplicationTests

### 服务端配置

```
<dependency>
    <groupId>com.htnova</groupId>
    <artifactId>signature-server</artifactId>
    <version>1.1.1</version>
</dependency>
```

服务端使用方法：

```
boolean result = SignatureUtil.getInstance(secretKey, Collections.singleton(SIGN_PARAM))
                .verifySignature(cachedBodyHttpServletRequest, signature);
```

注意：服务端由于需要重复从Request里读取InputStream，所以需要cachedBodyHttpServletRequest

参考: SignatureFilter

## 发布

客户端、服务端的代码已经发布到maven仓库里，如果有代码有更新，需要重新发布。

发布步骤如下：

1. 修改 `signature-client` 或 `signature-server` module下的 version
2. 执行 module 下的`publish.sh`脚本
