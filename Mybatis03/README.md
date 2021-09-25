## #和$ 的区别

### #特点：

在参数是一个非pojo类型时，该值可以是任何的内容，只是负责占位而已。
select * from user where id=?    预编译sql  PreparedStatement  放置sql注入

### $特点：

select * from user where id=1    Statement   相当于字符串的拼接

### 注意:

1. #{}只是替换?，相当于PreparedStatement使用占位符去替换参数，可以防止sql注入。
2. ${}是进行字符串拼接，相当于sql语句中的Statement，使用字符串去拼接sql ;$可以是sqli中的任一部分传入到Statement中，不能防止sql注入。
3. 使用${}去取出参教值信息,需要使用$[value)
4. #{}只是表示占位，与参数的名字无关，如果只有一个参数，会自动对应。