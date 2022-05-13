### Linux

#### 环境

* 安装VMware16和centOS8

* 网络连接的三种模式
  * 桥接模式：虚拟系统可以和外部系统通讯，但是容易造成IP冲突
  * NAT模式：虚拟系统可以和外部系统通讯，外部不能找到虚拟系统，不会造成IP冲突
  * 主机模式：独立的虚拟系统

##### 克隆与快照

* 将虚拟机关闭后，右击选择克隆即可
* 右击选择快照，即可保存当前快照，想转换的时候点击快照管理，转到想去的快照

##### vmtools

* centOS8不需要装，自动就是装好的；主要是为了共享文件

##### Linux目录

* 在Linux中，一切皆文件(连CPU都是个文件夹)

* *bin*目录：存放着常用的命令；*sbin*：存放系统管理员使用的系统管理程序；

  *home*：存放普通用的主目录即每个用户都有一个目录；*root：root*管理员使用的超级目录

  *lib*：存放开机需要的基本的多态连接的共享库；*lost+found：*一般是空的，在非法关机后会存一些文件

  etc：配置文件；usr：应用程序的文件夹；boot：启动时相关文件；*proc*：映射文件夹和src，sys都不能动

  dev：类似于设备管理器；media：自动识别设备并挂载在该目录；mnt：挂载其他文件比如共享Windows的文件

  opt：一般存放安装包的文件夹；/usr/local：存放软件的目录；var：存放在不断变化的文件

#### Linux实操

##### 远程登陆

* 远程登录使用Xshell，如果要进行文件上传下载使用Xftp

##### vim编辑器

* 一般模式，编辑模式，命令行模式(刚进入就是一般模式-**i**进入编辑模式-esc退出到一般模式-:或者/进入命令行模式)
* vim 文件名 --->创建一个文件，进入后i可以进入编辑模式，最后esc＋:wq保存退出；:q或者:q!都是不保存退出
* 在一般模式：拷贝当前行yy，删除当初行dd，u是撤回；G到文件末，gg到文件头；输入行号再摁shift＋g快速定位
* 在命令行模式：输入要查找的单词之后回车，输入n查找下一个；set nu展示行号，set nonu不展示行号

##### 开关机&用户管理

* shutdown 默认是shutdown -h 1即：一分钟后关机；shutdown -h now 现在立刻挂机；shutdown -r now 现在重启
* -h是halt关闭；-r是reboot重启；sync将内存数据同步磁盘(可以在关机重启前执行sync保证内存数据写入了)
* su - 用户名：切换用户，logout注销；高权限到地权限不用密码，反之要密码。logout可以返回

##### 用户管理

* useradd 用户名：默认在home目录下面创建新用户，useradd -d 自定义目录 用户名；passwd创建密码，userdel 用户名：删除用户，无法登录了但是目录还在，userdel -r 用户名就去哪都删干净了；id 用户名：查询用户信息；当前用户信息：whoami
* 用户组：groupadd 用户组名，删除用户组：groupdel 用户组名；在创建用户的时候用户名就是一个用户组；将用户添加到用户组 useradd -g 用户组 用户名；移到用户组：usermod -g 用户组 用户名；若给用户添加用户组使用 -G(-g是直接覆盖)
* 用户组信息在/etc/group文件下

##### 实用指令

* init [0123456]切换运行级别，常用的就是0：关机，3：多用户有网状态，5：图形界面，6：重启

###### 文件目录命令

* man ls查看ls的帮助文档

* ```bash
  mkdir [选项] 要创建的目录   #用于创建目录
  # -p 创建多级目录
  ls -lh #文件大小按照M为单位列出文件
  rmdir 目录  #删除指定目录  这个命令只能删除空的目录
  rm -rf 目录  #删除指定目录包括目录下的所有文件和目录
  touch 文件名 #创建一个空文件
  ```

* ```bash
  cp [选项] source dest  #拷贝  source是源文件  dest是目标路径
  #-r 递归复制整个文件夹
  \cp -r sorce dest   #强制覆盖，不会提示是否覆盖
  ```

* ```bash
  rm 文件名 #移除
  #-r 递归删除整个文件夹   #-f 强制删除不提示
  ```

* ```bash
  mv #移动文件与目录或者是重命名
  #mv cat.txt pig.txt 在同一个目录下 (重命名为pig.txt)
  #mv 不同目录下 (移动)
  ```

* ```bash
  cat 文件 #查看文件内容 -n  显示行号
  more 文件 #查看文件 回车显示一行，空格翻页，q退出，=输出行号，:f当前文件名+行号
  less 文件 #查看大文件 pgDn下翻一页 pgUp上翻一页 /字串搜索 n 向下继续找 N向上继续找
  head 文件 #查找文件头 默认前十行 head -n 
  tail 文件 #查找文件尾 tail -n默认十行，tail -f 实时监控
  >   #输出重定向  （覆盖写）
  >> 	#追加
  ```

* ```bash
  #软链接指令  类似于windows里的快捷方式，主要存放了链接其他文件的路径
  ln -s [源文件或目录] [软链接名]    #给源文件创建一个软链接（相当于给源文件创建了一个快捷方式）
  rm -rf [软链接名]   #删除软链接  在删除软链接目录时，后面不要带/，否则提示资源忙
  ```

* ```bash
  history   #查看已经执行过的历史命令，也可以执行历史指令
  history 10   #查看最近使用的10个命令  10这个数字可以改变
  ！指令编号    #执行第多少条指令   ！178 执行编号为178的指令
  ```

###### 日期目录

* ```bash
  date		#显示当前时间
  date +%Y 	#显示当前年份
  date +%m		#显示当前月份
  date +%d		#显示当前是哪一天
  date "+%Y-%m-%d %H:%M:%S"	#显示年月日时分秒
  date -s #字符串时间  #设置系统当前时间  date -s "2019-06-19 10:03:00"
  cal #显示当前月的日历 cal 2022全年的都会展示
  ```

###### 搜索查找

* ```bash
  #find指令  将从指定目录向下递归的遍历其各个子目录，将满足条件的文件或者目录显示在终端
  find [搜索范围] [选项]
  #选项说明
  #-name <查询方式>   按照指定的文件名查找模式查找文件
  #-user <用户名>		查找属于指定用户名所有文件
  #-size <文件大小>   按照指定的文件大小查找文件
  
  #按文件名，根据名称查找/home目录下的hello.txt文件
  find /home -name hello.txt
  #按拥有者，查找/opt目录下，用户名称为root的文件
  find /opt -user root
  #查找整个linux系统下大于20M的文件（+n 大于    -n 小于    n 等于）
  find / -size +20M
  #查询根目录下，所有后缀为.txt的文件
  find / -name *.txt
  ```

* ```bash
  #locate指令  可以快速定位文件路径。locate指令利用事先建立的系统中所有文件名称及路径的locate数据库实现快速定位给定的文件。locate指令无需遍历整个文件系统，查询速度较快。为了保证查询结果的准确度，管理员必须定期更新locate数据库。
  locate 搜索文件
  #由于locate指令基于数据库进行查询，所以第一次运行前。必须使用updatedb指令创建locate数据库
  
  #使用locate指令快速定位hello.txt文件所在目录
  updatedb
  locate hello.txt
  ```

* ```bash
  grep 查找内容 文件名 #过滤查找 会把文件中的每一个内容都找出来
  # -n显示行号 -i不区分大小写
  ```

* ```bash
  gzip 文件				#压缩文件，只能将文件压缩为 *.gz 文件
  gunzip 文件.gz		#解压缩文件命令
  zip [选项] xxx.zip 将要压缩的内容	#压缩文件和目录的命令
  unzip [选项] xxx.zip				#解压缩文件
  #zip常用选项：-r  递归压缩，即压缩目录
  #unzip常用选项：-d <目录>   指定解压后文件的存放目录
  
  
  tar [选择] xxx.tar.gz 打包的内容	#打包目录，压缩后的文件格式是.tar.gz
  #常用选项
  #-c 	产生.tar打包文件 -C 指定解压位置
  #-v 	显示详细信息
  #-f		指定压缩后的文件名
  #-z		打包同时压缩
  #-x		解包.tar文件
  
  #案例
  #1、压缩多个文件，将/home/a1.txt和/home/a2.txt压缩成a.tar.gz
  tar -zcvf /home/a.tar.gz /home/a1.txt /home/a2.txt
  #2、将/home的文件夹压缩成myhome.tar.gz
  tar -zcvf myhome.tar.gz /home/
  #3、将a.tar.gz解压到当前目录下
  tar -zxvf a.tar.gz
  #4、将myhome.tar.gz解压到/opt目录下(指定的目录必须是存在的)
  tar -zxvf myhome.tar.gz -C /opt/
  ```

##### 组管理&权限管理

###### 组

* 在Linux中的每个用户必须属于一个组，不能独立于组外。
* 在linux中每个文件有所有者、所在组、其他组的概念。
* 用户tom创建的文件，该文件就属于tom也属于tom属于的组

```bash
#查看文件/目录拥有者详情
ls -ahl
#改变文件所有者
chown 用户名 文件名
#将目录下的所有目录文件的所有者以递归的方式修改
chown -R 用户名 目录名
#修改文件所属组
chgrp 组名 文件名
```

###### 权限管理

* ```bash
  ls -l#查看文件权限
  -   rwx  rw-  r--  1 tom  root  0  Jun 20 00:02  apple.txt
  1    2    3    4   5  6    7    8       9          10
  #1  文件的类型 [-：普通文件] [d:目录] [l:软链接] [c:字符设备（键盘，鼠标）] [b:快文件，硬盘]
  
  #2  表示文件/目录所有者权限
  #3   文件/目录所在组的其他用户的权限
  #4   文件/目录其它组的用户的权限
  #-----[r:可读(4)] -----[w:可写(2)]但不代表可以删除，除非对文件所在的目录有w权限
  #-----[x:可执行(1)]作用在目录上，如果你对这个目录没有x权限那么无法cd切入 -----[-:没有权限]
  
  #5  
  #如果是文件，表示硬链接的数
  #如果是目录，表示目录的子目录的个数
  
  #6  文件/目录所在用户
  #7  文件/用户所在组
  #8  文件的大小，单位：字节，，，如果是目录，显示4096
  #9  文件/目录最后的修改时间
  #10 文件/目录名
  ```

* ```bash
  修改文件目录权限
  #u:所有者（user） g:所有组（group） o:其他人（other） a:所有人（all）（u、g、o的总和）
  
  chmod u=rwx,g=rx,o=x 文件目录名
  #表示给所有者读、写、执行权限 ，给所有组读和执行权限，给其他人执行权限
  
  chmod o+w 文件目录名					chmod a-x 文件目录名
  #表示给其他人添加写的权限			   表示给所有人去除执行的权限
  ```

* ```bash
  chown 用户名 file    #改变文件的所有者
  chown 用户名:用户组 file #改变用户的所有者和所有组
  -R  #如果是目录  则使其下所有子文件或目录递归生效
  
  #案例
  #1、请将/home/abc.txt文件的所有者修改成tom
  chown tom abc.txt
  #2、请将/home/kkk目录下所有的文件和目录的所有者都修改成tom
  chown -R tom kkk/
  ```

##### 定时任务调度

###### crontab定时任务

* ```bash
  crontab [选项]
  #-e  编辑crontab定时任务 
  #例如：*/1 * * * * ls -l /etc/>/tmp/to.txt 注意格式1后面的*之间都要空格
  #-l  查询crontab任务
  #-r  删除当前用户所有的crontab任务
  service crond restart #重启定时任务
  ```

* | 项目     | 含义                 | 范围                    |
  | -------- | -------------------- | ----------------------- |
  | 第一个 * | 一小时当中的第几分钟 | 0-59                    |
  | 第二个 * | 一天当中的第几小时   | 0-23                    |
  | 第三个 * | 一个月当中的第几天   | 1-31                    |
  | 第四个 * | 一年当中的第几月     | 1-12                    |
  | 第五个 * | 一周当中的星期几     | 0-7（0和7都代表星期日） |

* | 特殊符号 | 含义                                                         |
  | -------- | ------------------------------------------------------------ |
  | *        | 代表任何时间。比如第一个"*"就代表一小时中每分钟都执行一次的意思。 |
  | ，       | 代表不连续的时间。比如"0 8,12,16 * * * * 命令"，就代表在每天的8点0分、12点0分、16点0分都执行一次命令 |
  | -        | 代表连续的时间范围。比如"0 5 * * 1-6 命令"，代表在周一到周六的凌晨5点0分执行命令 |
  | */n      | 代表每隔多久执行一次。比如"*/10 * * * * 命令"，代表每个10分钟就执行一次命令 |

* ```bash
  #每隔1分钟，将当前日期和日历都追加到/home/mycal文件中
  # 先编写一个文件 mytask2.sh
  date >> /home/mycal
  cal >> /home/mycal
  # 给mytask2.sh一个可执行权限
  chmod u=rwx mytask2.sh
  #crontab -e
  */1 * * * * /home/mytask2.sh
  ```

###### at定时任务

* at命令是一次性执行的命令，at的守护线程atd(ps -ef | grep atd 查看atd进程)每六十秒会执行一次即去工作队列中查看是否有符合时间的任务要执行，执行完后该任务就会抛出

* ```bash
  at 时间
  #进入后编写定时任务   Ctrl + D  两次  结束at命令的输入
  atq #查询at任务列表
  atrm  编号；  # 删除某个at队列
  ```

##### Linux磁盘分区&挂载

* lsblk 或者 lsblk -f查看分区挂载情况
* 虚拟机挂载硬盘https://blog.csdn.net/wei198621/article/details/115023640
* df -h  查看磁盘使用情况

* ```bash
  du -h /目录
  #查询指定目录的磁盘占用情况，默认为当前目录
  # -s 指定目录占用大小汇总
  # -h 带计量单位
  # -a 含文件
  # --max-depth=1 子目录深度
  # -c 列出明细的同时，增加汇总值
  
  #实例：查询/opt目录的磁盘占用情况，深度为1
  du -ach --max-depth=1 /opt
  ```

##### 网络配置

* 在Linux中查看网络配置ifconfig，Windows中是ipconfig

* 在vm中的编辑-->虚拟网络编辑器-->NAT模式可以查看现在的IP

* ```bash
  vim /etc/sysconfig/network-scripts/ifcfg-ens33 #这个文件不一定叫这个名字，但这个目录下只有这一个文件
  #修改文件内容：
  #	BOOTPROTO="static"
  #	加上：
  #		IPADDR=192.168.200.130   (IP地址,自己设定的)
  #		GATEWAY=192.168.200.2	 (网关,自己设定的)
  #		DNS1=192.168.200.2		 (域名解析器,自己设定的)
  #下一步：vmnet8和Linux在同一网段上，要能够通信，也要修改相应的vmnet8
  #vmware--->编辑--->虚拟网络编辑器
  #打开虚拟编辑器，点击vmnet8，修改下面的子网ip为：192.168.200.0
  #然后点击NAT设置，将网关改为192.168.200.2
  service network start  #重启网络 或者 reboot 重启系统，以后就是我们指定好的IP了 再也不会变了
  ```

###### 设置主机名&hosts映射

* hosts是一个文本文件用来记录IP和Hostname(主机名)的映射关系
* DNS是互联网上做为域名和IP地址互相映射的一个分布式数据库，通过DNS域名解析系统，将主机名解析为ip地址，实际上还是用的ip地址

```shell
#Linux系统的主机名相当于其ip地址，起一个主机名是因为ip地址不好记忆，不方便。
#也可以修改主机名。查看当前主机的主机名指令：hostname
#主机名放在/etc/hostname文件中，要修改主机名即修改文件内容：
vim /etc/hostname #--->修改内容--->:wq--->reboot重启系统
```

```bash
#在Windows中,修改ip地址与主机名的映射关系：
#在windows C:\Windows\System32\drivers\etc\hosts 文件中指定Linux系统的ip地址与主机名的映射关系
#格式：linux系统ip地址 linux系统主机名

#那么，如果也想在Linux系统中，使用主机名 来 ping 某个Windows系统，怎么做？
#	在 linux 系统的 /etc/hosts 文件中 指定，格式和在Windows中一样
```

* 用户在浏览器输入了www.baidu.com

     1.浏览器先检查浏览器缓存中有没有该域名解析 IP 地址，有就先调用这个 IP 完成解析；
        	  如果没有，就检查 DNS 解析器缓存，如果有直接返回 IP 完成解析。
        	  这两个缓存，可以理解为 本地解析器缓存

  * DNS 解析器缓存：
    一般来说，当电脑第一次成功访问某一网站后，在一定时间内，浏览器或操作系统会缓存他的 IP 地址（DNS 解析记录）
    	如在 cmd 窗口中输入
    	ipconfig /displaydns	//DNS 域名解析缓存
    	ipconfig /flushdns	//手动清理 dns 缓存

  2. 如果本地解析器缓存没有找到对应映射，检查系统中 hosts 文件中有没有配置对应的域名 IP 映射，如果有，则完成解析并返回。
  3. 如果本地 DNS 解析器缓存 和 hosts 文件 中均没有找到对应的 IP，则到域名服务器(互联网)找
  4. 还找不到，就没有了。


##### 进程管理

* 在Linux中每一个执行的程序都是一个进程，每个进程都会分配一个id(Pid，进程号)

* ```bash
  ps命令是用来查看目前系统中，有哪些进程正在执行，以及它们执行的状况。
  	可以不加任何参数。
  语法：ps -aux
  	ps [选项]    Process Status
  	选项：
  		-a		显示当前终端的所有进程信息
  		-u		以用户的格式显示进程信息
  		-x		显示后台程序运行的参数
  
  上述命令将所有进程显示出来，若只想查找某一个进程：
  	指令：ps –aux|grep xxx  
  	比如查找 sshd 进程：ps -aux | grep sshd
  	
  ps -ef 是以全格式显示当前所有的进程。-e 显示所有进程。-f 全格式。
  输入：ps -ef | grep sshd
  得到第三列为1，即父进程ID=1
  
  pstree #查看进程树，不加任何参数会看到完整的进程树
  -p #会显示pid
  -u #会显示用户
  ```

* ```bash
  kill 
  #杀死进程的指令，一般使用kill和kill all两种，kill all会把进程及其子进程全部杀死。
  #有时kill会无法生效，因为系统觉得不能杀死可以带参数 -9   表示强制终止进程
  ```

###### 服务管理

* ```bash
  systemctl [start | stop | restart | status] 服务名
  systemctl 指令管理的服务在 /usr/lib/systemd/system 查看
  
  systemctl list-unit-files [ | grep 服务名] (查看服务开机启动状态, grep 可以进行过滤) 
  systemctl enable 服务名 		(设置服务开机自启动)
  systemctl disable 服务名 	(关闭服务开机自启动)
  systemctl is-enabled 服务名  (查询某个服务是否是自启动的)
  
  centos7之后运行级别只有3和5，所以以上指令对3和5运行级别同时适用。
  
  注意：stop或者start设置后，立即生效。
  但是 这种方式只是临时生效，当重启系统后，还是回归以前对服务的设置。
  
  如果希望设置某个服务自启动或关闭永久生效
  	要使用 systemctl	[enable|disable] 服务名
  ```

* ```bash
  firewall #是操作防火墙的指令
  打开端口：firewall-cmd --permanent --add-port=端口号/协议
  
  #通过 netstat -anp | more 指令查看端口号的协议 (more 分页显示)
  关闭端口: firewall-cmd --permanent --remove-port=端口号/协议
  #注意：无论是打开端口还是关闭端口，要重新载入才能生效
  重新载入：firewall-cmd --reload
  #查询端口是否开放: firewall-cmd --query-port=端口/协议
  ```

* ```bash
  top 与 ps #命令很相似;它们都用来显示正在执行的进程。
  top 与 ps #最大的不同之处在于: top 在执行一段时间可以更新正在运行的的进程。
  top -d 秒数#就是指定秒数刷新，不写默认是-d 3
  top -i #不显示僵死线程和闲置线程
  top -p #指定监控
  #展示后有交互操作：P按照CPU使用率排序；M以内存使用率排序；N以PID排序；q退出；u查找用户；k杀死进程
  ```

* 监控网络状态

  ```bash
  netstat [选项]
  	-an	按一定顺序排列输出
  	-p	显示哪个进程在调用
  #会得到网络的信息：网络协议，接受/发送信息，本地/外部地，状态 
  #状态有：LISTEN 监听  ESTABLISHED 已建立连接 TIME_WAIT 超时等待
  netstat -anp | grep sshd#查看sshd的进程网络信息
  ```

##### RPM与YUM

* RPM 是 Red-Hat Package Manager（红帽软件包管理器）的缩写；类似于Windows中的setup.exe

```bash
#查询已安装的 rpm软件包 列表：
rpm –qa|grep xx 
rpm -qa #(查询所安装的所有 rpm 软件包) 比如 rpm -qa | grep firefox )

rpm -q  软件包名 	  #(查询某个软件包是否安装)
rpm -qi 软件包名 	  #(查询软件包的详细信息)
rpm -ql 软件包名 	  #(查询软件包中的文件和该软件包在哪个文件下)
rpm -qf 文件全路径名 	 #(查询某个文件所属在哪个软件包)rpm -qf /etc/passwd

rpm -e RPM软件包的名称 # 删除RPM -e erase擦去；例：rpm -e firefox 有可能有的文件删不掉因为有依赖关系
#可以增加参数 --nodeps ,就可以强制删除 rpm -e --nodeps foo (nodeps 不检查依赖关系 no dependencies)

rpm -ivh RPM软件包全路径名称 #rpm软件包其实是一个软件的安装包
	i=install 安装； v=verbose 提示； h=hash	进度条
rpm -ivh /run/media/root/CentOS\ 7\ x86_64/Packages/firefox-60.2.2-1.el7.centos.x86_64.rpm
#也可以在Packages中找到firefox安装包，复制到某一个目录下，这样写路径简单

```

###### yum

* Yum（全称为 Yellow dog Updater, Modified）是一个 Shell 前端软件包管理器。基于 RPM 包管理，能够从指定的服务器自动下载 RPM 包并且安装，可以自动处理依赖性关系，并且一次安装所有依赖的软件包。感觉就像应用商店

  ```bash
  yum list|grep 软件名 #向yum服务器查询有没有该软件
  yum install 软件名 #下载安装该软件，如果没有的话会什么都不返回
  ```

* rpm 是从本地安装包下载；yum 是从yum服务器下载安装软件

#### 搭建Java环境

1. 创建jdk目录-----> mkdir /opt/jdk
2. 去Oracle官网下载jdk8的Linux版本，通过xftp7上传jdk8的压缩包
3. 进入jdk文件夹，解压jdk8压缩包---->tar -zxvf jdk-8u333-linux-x64.tar.gz
4. 创建一个Java文件夹----->mkdir /usr/local/java
5. 移动/opt/jdk下的文件夹去/usr/local/java---->mv jdk1.8.0_333/ /usr/local/java/
6. 配置环境变量---->vim /etc/profile 
7. export JAVA_HOME=/usr/local/java/jdk1.8.0_333
   export PATH=$JAVA_HOME/bin:$PATH
8. source /etc/profile刷新文件以生效-------可以在任意位置输入java -version测试是否安装成功
