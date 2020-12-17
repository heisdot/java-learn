# 基础镜像
FROM livingobjects/jre8
# 维护者
MAINTAINER toolman
# 挂载点
VOLUME /tmp
# 添加文件
ADD java-learn.jar app.jar
# 执行命令
RUN bash -c 'touch /app.jar'
# 容器入口
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
# 暴露端口
EXPOSE 8995
# 执行命令
CMD ["/bin/bash"]

# Dockerfile参考 https://hjwjw.gitee.io/posts/1ef71e38/#Dockerfile%E7%9A%84%E6%96%87%E4%BB%B6%E7%BB%93%E6%9E%84