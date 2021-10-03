# 延迟加载

延迟加载的意义在于，虽然是关联查询，但不是及时将关联的数据查询出来，而且在**需要的时候进行查询。**

```text
        <!-- 打开延迟加载 的开关 -->
        <setting name="lazyLoadingEnabled" value="true"/>
        <!-- 将积极加载改为消极加载即按需要加载 -->
        <setting name="aggressiveLazyLoading" value="false"/>
```

lazyLoadingEnabled: true使用延迟加载，false禁用延迟加载。默认为trueaggressiveLazyLoading: true启用时，当延迟加载开启时访问对象中一个懒对象属性时，将完全加载这个对象的所有懒对象属性。false，当延迟加载时，按需加载对象属性\(即访问对象中一个懒对象属性，不会加载对象中其他的懒对象属性）。默认为true。



