#! /usr/bin/env python
# coding: utf-8
import codecs
import io
import time

from base import *


class Coder(Base):

    def __init__(self):
        Base.__init__(self)
        self.const_common = None

    def coding(self, path):
        if path is None or not os.path.exists(path):
            path = os.getcwd() + "/conf/config.json"
            self.logger.warn("指定配置路径不存在，指向默认路径：{}".format(path))
        self.logger.info("配置路径：{}".format(path))
        s = self.read_config(path)
        read_path = s["read_path"]
        if read_path is None or not os.path.exists(read_path):
            read_path = os.getcwd() + "/template"
            self.logger.warn("指定读取路径不存在，指向默认路径：{}".format(read_path))
        out_path = s["out_path"]
        if out_path is None or not os.path.exists(out_path):
            out_path = os.getcwd() + "/output"
            os.makedirs(out_path)
            self.logger.warn("指定输出路径不存在，指向并创建默认路径：{}".format(out_path))
        self.logger.info("读取路径：{}".format(read_path))
        self.logger.info("输出路径：{}".format(out_path))
        self.const_common = s["operate"]["common"]
        if s["operate"] is not None and s["operate"]["replace"] is not None:
            operations = s["operate"]["replace"]
            for root, dirs, files in os.walk(read_path):
                self.logger.info("遍历文件集合：{}".format(files))
                for filesPath in files:
                    fllePath = os.path.join(root, filesPath)
                    try:
                        [dirName, fileName] = os.path.split(fllePath)
                        self.logger.info(
                            "读取文件：{}/{}，字符集：{}".format(dirName, fileName, s["charset"]))
                        i = io.open(fllePath, "r", encoding=s["charset"])
                        if s["operate"]["rename"] is not None and s["operate"]["rename"][fileName] is not None:
                            fileName = self.rename(
                                fileName, s["operate"]["rename"][fileName])
                            self.logger.info(
                                "文件重命名：{}".format(fileName))
                        o = io.open(out_path + "/" + fileName,
                                    "w", encoding=s["charset"])
                        template = ""
                        for line in i.readlines():
                            template += line
                        i.flush()
                        i.close()
                        for key in operations:
                            if template.find(key) != -1:
                                self.logger.debug(
                                    "替换KEY：{}，替换信息：{}".format(key, operations[key]))
                                template = self.replace(
                                    template, key, operations[key])
                        o.writelines(template)
                        o.flush()
                        o.close()
                    except (IOError, RuntimeError), e:
                        self.logger.error(
                            "读取：{}文件失败！异常信息：{}".format(fllePath, e.message))
                        continue
            self.logger.info("生成完成")
        else:
            self.logger.error("生成失败")

    def rename(self, x, y):
        for commonKey in self.const_common:
            if y.find(commonKey) != -1:
                y = y.replace(commonKey, self.const_common[commonKey])
        if y.find("#{now}") != -1:
            y = y.replace("#{now}", time.strftime(
                "%Y/%m/%d %H:%M:%S", time.localtime()))
        if y.find("#{datetime}") != -1:
            y = y.replace("#{datetime}", time.strftime(
                "%Y%m%d%H%M%S", time.localtime()))
        if y.find("#{timestamp}") != -1:
            y = y.replace("#{timestamp}", time.time())
        return x.replace(x, y)

    # s 表示要被替换的内容
    # x 表示要被替换的字符串
    # y 表示替换后的字符串
    def replace(self, s, x, y):
        for commonKey in self.const_common:
            if y.find(commonKey) != -1:
                y = y.replace(commonKey, self.const_common[commonKey])
        if y.find("#{now}") != -1:
            y = y.replace("#{now}", time.strftime(
                "%Y/%m/%d %H:%M:%S", time.localtime()))
        if y.find("#{datetime}") != -1:
            y = y.replace("#{datetime}", time.strftime(
                "%Y%m%d%H%M%S%s", time.localtime()))
        if y.find("#{timestamp}") != -1:
            y = y.replace("#{timestamp}", time.time())
        s = s.replace(x, y)
        if s.find("#{now}") != -1:
            s = s.replace("#{now}", time.strftime(
                "%Y/%m/%d %H:%M:%S", time.localtime()))
        if s.find("#{datetime}") != -1:
            s = s.replace("#{datetime}", time.strftime(
                "%Y%m%d%H%M%S", time.localtime()))
        if s.find("#{timestamp}") != -1:
            s = s.replace("#{timestamp}", time.time())
        return s

    def read_config(self, path):  # 读取配置
        if None == self.const_config:
            # config_path = os.getcwd() + path
            config_path = path
            if os.path.exists(config_path):
                with open(config_path) as fp:
                    self.const_config = json.load(fp)
                    return self.const_config
            else:
                self.logger.error("找不到配置文件")
        else:
            return self.const_config
