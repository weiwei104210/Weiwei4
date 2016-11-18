package com.example.weiwei.util;

public class DataUtils {
    public static final String[] TITLES = {"title1", "title2", "title3", "title4", "title5"};
    public static final String[] DETAILS = {"This is title1", "This is title2",
            "This is title3", "This is title4", "This is title5"};
    public static final String[] QUESTION = {"Android系统架构是什么", "Andorid应用的目录结构",
            "列举基本UI组件的常见属性有哪些", "Android的常见布局",
            "相对布局中常见的属性", "创建Activity的步骤", "Activity的跳转分类", "Activity的生命周期",
            "Activity的运行模式 ", "开启服务的两种方式以及区别", "注册接收者的两种方式以及区别",
            "内容提供者的作用和sql实现的区别", "Android的数据存储分类", "SharedPreference数据存储的特点",
            "手机内部文件存储的特点", "手机外部文件存储的特点", "SQLite数据库存储的特点", "实现服务端和客户端交互的常用方式有哪些",
            "子线程更新UI有哪些方式", "什么是三级缓存", "消息处理机制的原理", "事件分发机制的原理",
            "Android中的动画分类", "自定义Shape中使用的节点有哪些", "Fragment的生命周期", "Fragment的特点",
            "Fragment加载有几种方式", "横竖屏切换时生命周期的方法会走哪些", "AsyncTask主要使用的方法",
            "Fragment和Activity之间如何传递数据", "http和https的区别", "Service里可以弹吐司吗",
            "padding和margin的区别", "将Activity设置成窗口样式", "两个Activity之间如何传递数据", "后台Activity被系统回收怎么办，如何保存回收前的状态",
            "同一个程序不同Activity是否可以放在不同任务栈", "service是否在mainThread执行，能否执行耗时操作"};
    public static final String[] ANSWER = {"一共分为四层，从最底层到最顶层排列如下\n" +
            "\t\tLinux内核\n" +
            "\t\t系统函数库+Android运行时\n" +
            "\t\t应用程序框架层\n" +
            "\t\t应用程序层"
            ,
            "src 源文件\n" +
                    "res 资源文件\n" +
                    "drawable 图片资源\n" +
                    "values\t值资源\n" +
                    "gen 自动生成的文件\n" +
                    "AndroidManifest.xml清单列表\n" +
                    "bin 生成的二进制文件\n" +
                    "assert 资产目录\n" +
                    "lib  依赖的jar包"
            ,
            "TextView：\n" +
                    "\t\ttext     文本\n" +
                    "\t\ttextColor字体颜色\n" +
                    "\t\ttextSize  字体大小\n" +
                    "\t\tdrawableLeft/drawableRight  图标\n" +
                    "\t\tellipsize 省略号位置\n" +
                    "\t\tsingleLine 是否单行显示\n" +
                    "\t\tmaxLines  最大显示行数\n" +
                    "EditText：\n" +
                    "\t\thint\t\t 提示文字\n" +
                    "\t\tinputType 输入类型\n" +
                    "ImageView：\n" +
                    "\t\tsrc\t\t  图片\n" +
                    "\t\tbackground 背景\n" +
                    "\t\tscaleType\t  缩放类型"
            ,
            "相对布局 RelativeLayout\n" +
                    "\t线性布局 LinearLayout\n" +
                    "\t帧布局   FrameLayout\n" +
                    "\t表格布局 TableLayout\n" +
                    "\t绝对布局 AbsoluteLayout"
            ,
            "属性一：相对于 父元素的对齐方式，属性值：true| false\n" +
                    "\n" +
                    "\tcenterInParent 正居中\n" +
                    "\tcenterHorizatal 水平居中\n" +
                    "\tcenterVertical 垂直居中\n" +
                    "\talignParentLeft 相对于父元素居左\n" +
                    "  alignParentRight 相对于父元素居右\n" +
                    "\talignParentTop 相对于父元素居上\n" +
                    "\talignParentLeft 相对于父元素居下\n" +
                    "\n" +
                    "属性二：相对于兄弟元素的位置，属性值：兄弟元素 的id @id/xx\n" +
                    "\t toLeftOf 相对于兄弟元素居左\n" +
                    "   toRightOf 相对于兄弟元素居右\n" +
                    "   above 在指定兄弟元素上面\n" +
                    "   below 在指定兄弟元素下面\n" +
                    "\n" +
                    "属性三：相对于兄弟元素的对齐方式，属性值：兄弟元素 的id @id/xx\n" +
                    "         \n" +
                    "   alignTop 和指定兄弟元素上对齐\n" +
                    "   alignBottom 和指定兄弟元素下对齐\n" +
                    "   alignLeft 和指定兄弟元素左对齐\n" +
                    "   alignRight 和指定兄弟元素右对齐"
    ,
    "步骤一：定义类继承Activity \n" +
            "步骤二：功能清单文件注册\n" +
            "步骤三：完成对应的布局文件\n" +
            "步骤四：重写onCreate()方法，加载布局文件"
    ,
    "1.显式跳转\n" +
            "        Intent intent = new Intent(this,DestinationActivity.class);\n" +
            "  startActivity(intent);\n" +
            "        2. 隐式跳转\n" +
            "         Intent intent = new Intent();\n" +
            "\tintent.setAction(\"\");\n" +
            "\tintent.addCategory(\"\");\n" +
            "\tintent.setData(uri);\n" +
            "\tstartActivity(intent);"
    ,
    "onCreate\n" +
            "\tonStart\n" +
            "\tonResume\n" +
            "\tonRestart\n" +
            "\tonPause\n" +
            "\tonStop\n" +
            "\tonDestroy"
    ,
    "1. standard   默认标准的启动模式， 每次startActivity都是创建一个新的activity的实例。" +
            "适用于绝大大数情况\n" +
            "2. singleTop  单一顶部，如果要开启的activity在任务栈的顶部已经存在，就不会创建新的实例，而是调用 onNewIntent() 方法。" +
            "   应用场景： 浏览器书签。 避免栈顶的activity被重复的创建，解决用户体验问题。\n" +
            "3. singletask 单一任务栈 ， activity只会在任务栈里面存在一个实例。如果要激活的activity，在任务栈里面已经存在，就不会创建新的activity，而是复用这个已经存在的activity，" +
            "调用 onNewIntent() 方法，并且清空这个activity任务栈上面所有的activity。" +
            "应用场景：浏览器activity， 整个任务栈只有一个实例，节约内存和cpu的目的" +
            "   注意： activity还是运行在当前应用程序的任务栈里面的。不会创建新的任务栈。\n" +
            "4. singleInstance  单态 单例模式，单一实例，整个手机操作系统里面只有一个实例存在。不同的应用去打开这个activity共享 公用的同一个activity。他会运行在自己单独，独立的任务栈里面，并且任务栈里面只有他一个实例存在。" +
            "   应用场景：呼叫来电界面 InCallScreen"
    ,
    "方式一：一般启动，通过调用startService（）方法\n" +
            "方式二：绑定启动, 通过调用bindService( )方法\n" +
            "\n" +
            "区别：方式一，服务一旦启动将永久驻留在后台，除非人工手动停止\n" +
            "\t  方式二，随着Activity销毁而销毁，比较适合调用服务的方法时，使用此方式"
    ,
    "方式一：静态注册，通过清单列表配置<receiver />\n" +
            "方式二：动态注册，通过代码中调用方法 registerReceiver()方法\n" +
            "\n" +
            "区别：\n" +
            "方式一，注册的接收者哪怕应用关闭，依然能收听到广播\n" +
            "方式二，注册的接收者如果应用关闭，也随之解除注册"
    ,
    "数据库的数据默认是私有的，内容提供者可以提供统一的方式向其他应用暴露私有数据Sql也增删改查的方法.\n" +
            "  但是contentprovider 还可以去增删改查本地文件. xml文件的读取,更改,\n" +
            "网络数据读取更改"
    ,
    "手机内部文件存储\n" +
            "\t手机外部文件存储\n" +
            "\tSharedPreference文件存储\n" +
            "\t数据库存储\n" +
            "\t网络远程存储"
    ,
    "1、存储的类型是 简单类型的小数据，比如 String、int、double、boolean\n" +
            "\t2、存储的形式是 键值对形式\n" +
            "\t3、存储的位置：/data/data/应用的包名/shared_prefs/xx.xml\n" +
            "\t4、应用卸载时，数据也销毁\n" +
            "\t5、一般用于存储私有的数据"
    ,
    "1、存储大类型数据，比如文本文件、音频、图片、视频等\n" +
            "2、存储的路径：/data/data/应用的包/文件\n" +
            "3、应用卸载时，数据会销毁\n" +
            "4、一般用于存储私有的数据"
    ,
    "1、存储任意类型数据，比如 图片、音频、视频等\n" +
            "2、存储的路径\n" +
            "\t路径1：/storage/sdcard/Android/data/packageName/files/文件\n" +
            "\t路径2：/storage/sdcard/文件\n" +
            "3、读写数据必须在sd卡挂载状态下  \n" +
            "4、读写数据需要权限 \n" +
            " <uses-permission android:name=\"android.permission.READ_EXTERNAL_STORAGE\"/>\n" +
            " <uses-permission android:name=\"android.permission.WRITE_EXTERNAL_STORAGE\"/>"
    ,
    "1、存储结构化数据\n" +
            "\t2、存储路径 /data/data/packageName/databases/xx.db\n" +
            "\t3、数据库本身是一个db文件\n" +
            "\t4、默认数据是私有的，可以通过内容提供者向外暴露数据"
    ,
    "1、原生态的HttpURLConnection\n" +
            "2、谷歌的HttpClient\n" +
            "3、开源框架:Volley Xutils3 okHttp"
    ,
    "1、runonUIThread方法\n" +
            "2、Handler发送和处理消息\n" +
            "3、AsyncTask异步框架的使用"
    ,
    "三级缓存是指 内存——文件——网络 三层存储"
    ,
    "主线程维护了一个Looper轮询器，里面有一个消息池，Looper通过死循环不断工作检测,消息池中是否有新消息进来，如果有，则交给消息发送者Handler处理"
    ,
    "事件一层一层往下传递，传到最底层，如果事件被消费掉则不再往回传，否则将一层一层继续往回传，直到事件消费掉为止"
    ,
    "帧动画\n" +
            "补间动画\n" +
            "\t透明动画\n" +
            "\t缩放动画\n" +
            "\t平移动画\n" +
            "\t旋转动画\n" +
            "\t动画合集"
    ,
    "<corner /> 圆角角度\n" +
            "<solid /> 填充颜色\n" +
            "<gradient />渐变色\n" +
            "<size /> 宽高大小\n" +
            "<stroke> 边框设置\n" +
            "<padding />填充"
    ,
    "onAttatch\n" +
            "onCreate\n" +
            "onCreateView\n" +
            "onActivityCreate\n" +
            "onStart\n" +
            "onResume\n" +
            "onPause\n" +
            "onStop\n" +
            "onDestroy\n" +
            "onDestroyView\n" +
            "onDetatch"
    ,
    "1、Fragment提高了重用性、复用性，一个Fragment可以被多个Activity加载\n" +
            "\t2、Fragment 依赖于Activity，通过Activity增删改查Fragment\n" +
            "\t3、Fragment 可以实现切换更流畅\n" +
            "\t4、Fragment也有自己的生命周期，也可以处理自己的事件交互，实际上就是一个类\n" +
            "\t5、Fragment随着Activity的销毁而销毁"
    ,
    "1、静态加载\n" +
            "\t通过xml中，引入<fragment />标签\n" +
            "\t2、动态加载\n" +
            "\t通过FragmentManager对象开启事务添加"
    ,
    "1、不设置Activity的android:configChanges时，切屏会重新调用各个生命周期\n" +
            "默认首先销毁当前activity,然后重新加载\n" +
            "2、设置Activity的android:configChanges=\"orientation|keyboardHidden|screenSize\"时，\n" +
            "切屏不会重新调用各个生命周期，只会执行onConfigurationChanged方法\n" +
            "这个生命周期跟清单文件里的配置关系\n" +
            "游戏开发中, 屏幕的朝向都是写死的。"
    ,
    "onPreExecute()\n" +
            "在主线程中执行 异步开始前调用 做一些准备工作\n" +
            "doInBackground（Params...params）\n" +
            "分线程中执行  还可以通过publishProgress方法来更新任务\n" +
            "onProgressUpdate(Progress...values)\n" +
            "在主线程中执行当后台任务的执行进度发生改变时此方法会被调用\n" +
            "onPostExecute(Result result) \n" +
            "在主线程中执行，异步任务执行之后，此方法会被调用  result 是 doingBackground的返回值\n" +
            "onCancelled（）\n" +
            "在主线程中被调用当异步任务取消的时候会被调用这个时候onPostExecute（）将不会再被调用"
    ,
    "Activity 向 Fragment 传递数据 :\n" +
            "一 通过bundle设置参数\n" +
            "   \tBundle bundle = new Bundle();\n" +
            "\tbundle.putString(\"name\",\"加多宝\");\n" +
            "\tsf.setArguments(bundle);\n" +
            "二 通过调用接口\n" +
            "  设置一个接口 让被接收数据方 实现该方法\n" +
            "  让发送方调用该接口\n" +
            "Fragment 向 A ctivity 传递数据 :\n" +
            "    一 通过 getActivity 强转成 需要接收数据的Activity 调用其方法"
    ,
    "http和https使用的是完全不同的连接方式,用的端口也不一样,前者是80,后者是443。\n" +
            "http的连接很简单,是无状态的,... \n" +
            "HTTPS协议是由SSL+HTTP协议构建的可进行加密传输、身份认证的网络协议\n" +
            "要比http协议安全"
    ,
    "可以弹吐司.\n" +
            "可以弹对于对话框, 需要加权限\n" +
            "AlertDialog dialog = \n" +
            "new\tAlertDialog.Builder(this)\n" +
            ".setTitle(\"标题\")\n" +
            ".setMessage(\"内容\")\n" +
            ".setPositiveButton(\"确定\", null)\n" +
            ".create();\n" +
            "dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);\n" +
            "dialog.show();\n"+
            "<uses-permission android:name=\"android.permission.SYSTEM_ALERT_WINDOW\" />\n" +
            "/显示一个系统界别的dialog，即全局性质的dialog。这种dialog在任何界面下都可以弹出来。"
    ,
    "Padding 文字对边框, margin是控件对父窗体. android:layout_xxx, android:xxx\n" +
            "Margin：一个控件与另一个控件之间的间距  \n" +
            "Padding：一个控件的内容与边框之间间距"
    ,
    "可以自定义一个activity的样式\n" +
            " android:theme=\"@android:style/Theme.Dialog\""
    ,
    "1  intent 传递数据\n" +
            "2  sp传递数据\n" +
            "3  数据库传递数据"
    ,
    "可以每隔一段时间保存一次, 保存到本地, 下次启动时恢复.\n" +
            "例如：\n" +
            "第一种情况  资源相关的系统配置 发生改变导致Activity被杀死并重建 比如 横竖屏的切换\n" +
            "第二种情况  当资源内存不足导致低优先级的Activity被杀死  \n" +
            "第三种情况  按下Home键时也会被调用\n" +
            "第四种情况  起动另一个Activity时也会被调用\n" +
            "onSaveInstanceState这个方法只会发生在Activity异常终止的情况下  调用在 onStop前\n" +
            "onRestoreInstanceState 这个方法调用在再次被创建的时候 \n" +
            "onSaveInstanceState()方法只适合保存瞬态数据, 比如UI控件的状态, 成员变量的值等，而不应该用来保存持久化数据，持久化数据应该当用户离开当前的 activity时，在 onPause() 中保存（比如将数据保存到数据库或文件中）。说到这里，还要说一点的就是在onPause()中不适合用来保存比较费时的数据，所以这点要理解。\n" +
            "protected void onSaveInstanceState(Bundle outState) {\n" +
            "\tsuper.onSaveInstanceState(outState);\n" +
            "\toutState.putLong(\"id\", 1234567890);\n" +
            "}\n" +
            "public void onCreate(Bundle savedInstanceState) {\n" +
            "//判断 savedInstanceState是不是空.\n" +
            "//如果不为空就取出来\n" +
            "        super.onCreate(savedInstanceState);\n" +
            "}"
    ,
    "可以放在不同的task任务栈中\n" +
            "比方说在激活一个新的activity时候, 给intent设置flag\n" +
            "Intent的flag添加FLAG_ACTIVITY_NEW_TASK\n" +
            "这个被激活的activity就会在新的task栈里面……\n" +
            "Intent intent = new Intent(A.this,B.class);\n" +
            "intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);\n" +
            "startActivity(intent);"
    ,
    "默认情况,如果没显示的指定service所运行的进程, \n" +
            "Service和activity是运行在当前app所在进程的main thread(UI主线程)里面  \n" +
            "service里面不能执行耗时的操作(网络请求,拷贝数据库,大文件 )\n" +
            "在子线程中执行 new Thread(){}.start();\n" +
            "Thread.currentThread().getName();\n" +
            "特殊情况 ,可以在清单文件配置 service 执行所在的进程 ,让service在另外的进程中执行 \n" +
            "ActivityManagerService"};
}
