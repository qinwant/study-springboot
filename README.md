## Git的使用

> 最新更新：2020/11/27  整理归纳
>
> 更新记录：
>
> - 2020/11/26  模拟push冲突、总结反馈
>
> - 2020/11/25 基本开发规范，命令总结
> - 2020/11/24 git基本使用、关联远程分支
>
> 未完待续。。。

[toc]- [Git的使用](#git的使用)
  - [任务二过程记录](#任务二过程记录)
    - [1. 模拟协作时提交冲突及解决](#1-模拟协作时提交冲突及解决)
      - [1.1 关联远程项目](#11-关联远程项目)
      - [1.2 模拟冲突情况](#12-模拟冲突情况)
    - [2. 总结](#2-总结)
      - [2.1 任务二总结](#21-任务二总结)
      - [2.2 git学习总结](#22-git学习总结)
  - [1. Git介绍](#1-git介绍)
    - [1.1 分布式版本控制管理工具](#11-分布式版本控制管理工具)
    - [1.2 协同开发的利器](#12-协同开发的利器)
  - [2. 配置git环境](#2-配置git环境)
    - [2.1 Windows下搭建git](#21-windows下搭建git)
    - [2.2 Linux下搭建git](#22-linux下搭建git)
  - [3. 创建本地仓库](#3-创建本地仓库)
      - [3.1 成功创建的情况](#31-成功创建的情况)
  - [4. 创建远程仓库](#4-创建远程仓库)
    - [4.1 创建`github`远程仓库](#41-创建github远程仓库)
      - [New repository](#new-repository)
      - [说明](#说明)
    - [4.2 创建码云远程仓库](#42-创建码云远程仓库)
      - [5.1 关联方式](#51-关联方式)
  - [6. 常见命令总结](#6-常见命令总结)
    - [6.1 创建git仓库](#61-创建git仓库)
    - [6.2 本地操作](#62-本地操作)
    - [6.3 提交历史](#63-提交历史)
    - [6.4 分支与标签](#64-分支与标签)
    - [6.5 更新与发布](#65-更新与发布)
    - [6.6 merge和rebase](#66-merge和rebase)
    - [6.7 撤销操作](#67-撤销操作)
  - [7. 如何协同开发](#7-如何协同开发)
    - [7.1 创建开发分支](#71-创建开发分支)
    - [7.2 fork项目到个人仓库/直接在dev开发](#72-fork项目到个人仓库直接在dev开发)
    - [7.3 clone项目到本地](#73-clone项目到本地)
    - [7.4 和团队项目保持同步](#74-和团队项目保持同步)
    - [7.5 push修改到自己的本地版本](#75-push修改到自己的本地版本)
    - [7.6 请求合并](#76-请求合并)
    - [7.7 审核合并请求](#77-审核合并请求)
  - [8. 常见问题解决](#8-常见问题解决)
    - [8.1 文件提交](#81-文件提交)
  - [9. 实际开发规范](#9-实际开发规范)
    - [9.1 分支命名](#91-分支命名)
      - [master分支](#master分支)
      - [develop分支](#develop分支)
      - [feature分支](#feature分支)
      - [release分支](#release分支)
      - [hotfix分支](#hotfix分支)
    - [9.2 常见任务](#92-常见任务)
      - [增加新功能](#增加新功能)
      - [修复紧急Bug](#修复紧急bug)
      - [测试环境代码](#测试环境代码)
      - [生产环境上线](#生产环境上线)
    - [9.3 日志规范](#93-日志规范)
      - [格式`<type>:<subject>`](#格式typesubject)

### 任务二过程记录

#### 1. 模拟协作时提交冲突及解决

##### 1.1 关联远程项目

- 克隆远程项目

  ```yml
  git clone https://github.com/qinwant/study-springboot.git
  ```

  ![image-20201126223435175](https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201126223436.png)

- 查看本地项目分支(只显示`master`)

  ```yml
  git branch
  ```

  ![image-20201126223455322](https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201126232719.png)

- 查看仓库所有分支

  ```yml
  git branch -a
  ```

  ![image-20201126223621377](https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201126223622.png)

- 关联远程分支`dev`

  ```yml
  git checkout -b dev origin/dev
  ```

  ![image-20201126223736444](https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201126223738.png)

- 在`dev`分支下修改内容并提交到本地仓库

  ![image-20201126223954370](https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201126223956.png)

- 推送到远程仓库

  ```yml
  git push origin dev
  ```

  ![image-20201126224107009](https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201126224109.png)

##### 1.2 模拟冲突情况

- 其他协作者修改`test.md`内容并`push`

- 本地同时再次修改`test.md`，并提交

  ![image-20201126224342568](https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201126224344.png)

- 提交失败。**解决：拉取最新版本，解决冲突**

  ```yml
  git pull
  ```

  ![image-20201126224440583](https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201126224442.png)

- 手动解决冲突

  ![image-20201126222932211](https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201126222933.png)

  ![image-20201126224817415](https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201126224818.png)

- 再次push

  ![image-20201126224905722](https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201126224907.png)

#### 2. 总结

##### 2.1 任务二总结

- 学到了协同开发的一些基本规范（`master`存稳定版，协同开发要在`dev`分支）
- 知道了怎么邀请开发者协同、保护分支等
- 体会到了使用git协同的好处（开发者的不确定性；版本管理的思维，应用范围不仅仅在代码）

##### 2.2 git学习总结

- 就像一个人的某些有点吸引到你，才会想要近距离接触。git同样是这个道理，只有先明白它的好处才会想要深入学习使用它。

- git常见命令就那么几个，多敲几次就可以了。关键需要理解git的一些概念，远程仓库、本地仓库、本地缓存区等。

  ![image-20201126230734183](https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201126230819.png)

- 忘记了命令不怕，只有常用才能熟悉，遇见问题先分析产生的场景，再来思考解决方案。

- 要有意识记录问题，方便下次遇见及时定位及时解决

### 1. Git介绍

#### 1.1 分布式版本控制管理工具

#### 1.2 协同开发的利器

> 查看提交日志、提交、创建里程碑和分支、合并分支、回退等所有操作都在本地完成而不需要通过网络连接

### 2. 配置git环境

#### 2.1 Windows下搭建git

- 下载安装git：[git地址](https://git-scm.com/downloads)

- 找到`Git`，运行`Git Bash`

- 全局配置用户名邮箱

  ```yml
  git config --global user.name "用户名"
  git config --global user.password "邮箱"
  ```

#### 2.2 Linux下搭建git

- 命令安装

  ```yml
  sudo apt-get install git
  ```

### 3. 创建本地仓库

- 新建一个文件夹作为git仓库

- git命令初始化化文件夹

  ```yml
  git init
  ```

##### 3.1 成功创建的情况

- 文件夹下出现`.git`的隐藏文件

- 控制台出现如下输出

  ```yml
  Initialized empty Git repository in D:/JavaEEProject/MyGitRepository/.git/
  # D:/JavaEEProject/MyGitRepository为你的文件夹所在路径
  ```

### 4. 创建远程仓库

#### 4.1 创建`github`远程仓库

##### New repository

登陆自己的github，右上角+号，`New repository`，填写相关信息

![image-20201124215540460](https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201124215542.png)

##### 说明

- Public：公开仓库
- Private：私有仓库
- Add a README file： 说明文档，可先不创建
- Add .gitignore：设置忽略一些特定的文件（git时不会提交）
- Choose a license：选择许可证（可不勾选）

#### 4.2 创建码云远程仓库

###5. 关联远程仓库

##### 5.1 关联方式

- SSH

- Git

  ```yml
  # 初始化本地git仓库
  git init
  # 完本地仓库添加一个README.md的Markdown文件（非必须）
  git add README.md
  # 往本地仓库提交一次，提交内容说明:first commit
  git commit -m "first commit"
  # 与远程仓库关联
  git remote add origin https://github.com/qinwant/MyGitRepository.git
  # 同步推送本地仓库的提交到远程仓库mastet分支
  git push -u origin master
  ```

> 注意：使用`HTTPS`的方式可能会出现每次push都需要验证用户名密码，解决详见8.常见问题解决

### 6. 常见命令总结

#### 6.1 创建git仓库

- 克隆一个已存在的仓库

  ```yml
  git clone https://gitclone.com/github.com/qinwant/MyGitRepository.git
  ```

- 创建一个新的本地仓库

  ```yml
  git init
  ```

#### 6.2 本地操作

- 查看当前工作目录下改变的文件

  ```yml
  git status
  ```

- 跟踪改变的文件

  ```yml
  git diff
  ```

- 加入所有改变的文件到下次提交

  ```yml
  git add .
  ```

- 加入部分改变的文件到下次提交

  ```yml
  git add -p <file>
  ```

- 提交所有改变的文件

  ```yml
  git commit -a
  ```

- 提交

  ```yml
  git commit 
  ```

- 改变最后一次提交

  ```yml
  git commit --amend
  ```

#### 6.3 提交历史

- 显示所有的提交，从最新的提交开始

  ```yml
  git log
  ```

- 显示一个指定文件的改变记录

  ```yml
  git log -p <file>
  ```

- 显示谁在什么时候对指定的文件做了什么操作

  ```yml
  git blame <file>
  ```

#### 6.4 分支与标签

- 罗列所有分支

  ```yml
  git branch -av
  ```

- 切换分支

  ```yml
  git checkout <branch>
  ```

- 基于当前的HEAD创建一个新的分支

  ```yml
  git branch <branch-name>
  ```

- 基于一个远程分支创建一个新的分支

  ```yml
  git checkout --track <remote/branch>
  ```

- 删除一个本地分支

  ```yml
  git branch -d <branch>
  ```

- 在当前提交上打上标签

  ```yml
  git tag <tag-name>
  ```

#### 6.5 更新与发布

```yml
git remote -v # 查看所有的远程版本
git remote show <remote> # 显示远程仓库的信息
git remote add <shortname> <url> # 向远程添加一个仓库
git fetch <remote> # 从远程下载所有更改，不集成到HEAD中
git pull <remote> <branch> # 拉取远程的所有更改，并集成到HEAD中
git push <remote> <branch> # 向远程推送
git branch -dr <remote/branch> # 删除分支
git push --tags # 发布标签
```

#### 6.6 merge和rebase

```yml
git merge <branch> # 合并分支
git rebase <branch> 
git rebase --abort # 终止rebase
git rebase --continue # 解决冲突后继续rebase
git mergetool # 使用配置的合并工具解决冲突
git add <resolved-file> # 手动解决冲突
git rm <resolved-file>
```

#### 6.7 撤销操作

```yml
git reset --hard HEAD # 丢弃所有更改
git checkout HEAD <file> # 放弃指定文件中的修改
git revert <commit> # 还原提交
git reset --hard <commit> # 回到上次提交
git reset <commit> # 将所有更改保留为非暂存更改
git reset --keep <commit> # 保留未提交的本地更改
```

### 7. 如何协同开发

#### 7.1 创建开发分支

#### 7.2 fork项目到个人仓库/直接在dev开发

#### 7.3 clone项目到本地

#### 7.4 和团队项目保持同步

#### 7.5 push修改到自己的本地版本

#### 7.6 请求合并

#### 7.7 审核合并请求 

### 8. 常见问题解决

#### 8.1 文件提交

- 如何提交指定文件

  ```yml
  # 提交指定的单个文件'a.java'
  git commit a.java -m "修改了a.java"
  ```

- 切换分支的问题

  ```yml
  error: Your local changes to the following files would be overwritten by checkout
  # 使用git checkout <branch>时报错，原因在于当前分支存在未跟踪的文件，导致切换失败
  ```

  > 解决：
  >
  > 方案一：（未跟踪的文件内容比较重要）
  >
  > 保存修改
  >
  > > git add .
  > >
  > > git stash/git commit -m "或者直接提交"
  > >
  > > git stash pop(取出的时候使用)
  >
  > 方案二：
  >
  > 丢弃修改
  >
  > > git clean -n  清除文件预览
  > >
  > > git clean -f   强制清除文件
  >
  > 强制切换分支
  >
  > > git checkout -f < branch >

### 9. 实际开发规范

#### 9.1 分支命名

##### master分支

- 主分支，用于部署生成环境，确保`master`分支稳定性
- 一般由`develop`分支和`hotfix`分支合并
- 任何时间都不能直接修改代码

##### develop分支

- 开发分支，始终保持最新完成及bug修复后的代码
- 开发新功能时，`feature`分支一般都是基于`develop`分支创建

##### feature分支

- 分支命名：`feature/模块`，例如`feature/user_module`

##### release分支

- 预上线分支，一般在发布提测阶段

> 当`feature`分支开发完成，首先会合并到`develop`分支，进入提测阶段会创建`release`分支。测试阶段存在bug时，直接在`release`分支修复并提交，测试完成之后，合并`release`分支到`master`和`develop`分支，此时`master`为最新代码，用作上线。

##### hotfix分支

- 分支命名：hotfix/开头的为修复分支
- 线上出现紧急bug时，以master分支为基线，创建`hotfix`分支，修复完成后，合并到master和develop分支

####  9.2 常见任务

##### 增加新功能

```yml
(dev)$: git checkout -b feature/xxx  # dev建立特性分支
(feature/xxx)$: 增加功能
(feature/xxx)$: git add xxx
(feature/xxx)$: git commit -m "提交新功能"
(feature/xxx)$: git checkout dev
(dev)$: git merge feature/xxx --no-ff # 特性分支合并到dev
```

##### 修复紧急Bug

```yml
(master)$: git checkout -b hotfix/xxx
(hotfix/xxx)$: 修复bug
(hotfix/xxx)$: git add xxx
(hotfix/xxx)$: git commit -m "修复紧急bug"
(hotfix/xxx)$: git checkout master
(master)$: git merge hotfix/xxx --no-ff # hotfix分支合并到master,上线到生产环境
(dev)$: git merge hotfix/xxx --no-ff # hotfix分支合并到dev，同步代码
```

##### 测试环境代码

```yml
(release)$: git merge dev --no-ff # dev分支合并到release，并在测试环境拉取并测试
```

##### 生产环境上线

```yml
(master)$: git merge release --no-ff # 把测试好的release分支代码合并到master分支
(master)$: git tag -a v0.1 -m "部署包版本名" #给版本命名，打标签
```

#### 9.3 日志规范

##### 格式`<type>:<subject>`

- `type`：本次commit的类型
  - `feat`：添加新特性
  - `fix`：修复bug
  - `docs`：仅仅修改了文档
  - `style`：仅仅修改了空格、格式、缩进（不改变代码逻辑）
  - `refactor`：代码重构，没有加新功能或者修复bug
  - `perf`：增加代码进行性能测试
  - `test`：增加测试用例
  - `chore`：改变构建流程，增加依赖库、工具
- `subject`：简明扼要的阐述本次commit的主旨

