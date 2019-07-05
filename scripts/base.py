#! /usr/bin/env python
# coding=utf-8
import json
import logging
import os
from logging.config import fileConfig

class Base:
    def __init__(self):
        config_path = os.getcwd() + '/conf/logger.conf'
        fileConfig(config_path)
        self.logger = logging.getLogger(__name__)
        self.const_config = None