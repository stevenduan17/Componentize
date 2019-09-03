## :bangbang:ARouter在使用kotlin集成时遇到的几点问题

#### :white_check_mark:1. 传参：需要接收的成员变量需要暴露且非私有
```kotlin
    @Autowired
    @JvmField
    var obj: Obj? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
            
        val first = obj?.first    
        val second = obj?.second
    }
```

#### :white_check_mark:2. withObject()需要实现Object&Json的互转
```kotlin

    @Route(path = "/service/json")
    class JsonServiceImpl : SerializationService {
    
        override fun init(context: Context?) {
        }
    
        override fun <T> json2Object(input: String?, clazz: Class<T>?): T {
            return JSON.parseObject(input, clazz)
        }
    
        override fun object2Json(instance: Any?): String {
            return JSON.toJSONString(instance)
        }
    
        override fun <T> parseObject(input: String?, clazz: Type?): T {
            return JSON.parseObject(input, clazz)
        }
    }
```

#### :white_check_mark:3. withObject的自定义对象需要空参构造并且成员非私有
```java
    public class TestObject {
    
        public String f,s;
    
        public TestObject() {
        }
    
        public TestObject(String f, String s) {
            this.f = f;
            this.s = s;
        }
    }
```

```kotlin

    data class TestObj(
        var f: String? = null,
        var s: String? = null
    )
```

#### :white_check_mark:4. withObject传递参数使用FastJson无法获取结果，但Gson正常，暂未找到根本原因
```kotlin
    /**
    * 使用Gson作为序列化与反序列化
    */
    @Route(path = "/service/json")
    class JsonServiceImpl : SerializationService {
    
        private val GSON by lazy { Gson() }
    
        override fun init(context: Context?) {
        }
    
        override fun <T> json2Object(input: String?, clazz: Class<T>?): T {
            return GSON.fromJson(input, clazz)
        }
    
        override fun object2Json(instance: Any?): String {
            return GSON.toJson(instance)
        }
    
        override fun <T> parseObject(input: String?, clazz: Type?): T {
            return GSON.fromJson(input, clazz)
        }
    }
```

```kotlin
    /**
    * 使用FastJson进行序列化与反序列化
    */
    @Route(path = "/service/json")
    class JsonServiceImpl : SerializationService {
    
        override fun init(context: Context?) {
        }
    
        override fun <T> json2Object(input: String?, clazz: Class<T>?): T {
            return JSON.parseObject(input, clazz)
        }
    
        override fun object2Json(instance: Any?): String {
            return JSON.toJSONString(instance)
        }
    
        override fun <T> parseObject(input: String?, clazz: Type?): T {
            return JSON.parseObject(input, clazz)
        }
    }

```

#### :white_check_mark:5. 一级路由相同的类须在同一个“projectName"的包内，否则会抛出‘ARouter::There is no route match the path [/service/json], in group [service][ ] ’找不到路径