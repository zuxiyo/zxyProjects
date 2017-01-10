<template>
  <el-row class="tac" :gutter="10">
    <el-col :span="4">
      <el-menu default-active="/users" class="el-menu-vertical-demo" v-bind:router="true">
        <el-submenu index="2">
          <template slot="title"><i class="el-icon-message"></i>组织机构</template>
          <el-menu-item index="/users">用户管理</el-menu-item>
          <el-menu-item index="/depts">部门管理</el-menu-item>
          <el-menu-item index="/orgs">机构管理</el-menu-item>
        </el-submenu>
        <el-submenu index="3">
          <template slot="title"><i class="el-icon-menu"></i>权限管理</template>
          <el-menu-item index="/roles">角色</el-menu-item>
          <el-menu-item index="/menus">菜单</el-menu-item>
          <el-menu-item index="/permissions">权限</el-menu-item>
        </el-submenu>
        <el-submenu index="4">
          <template slot="title"><i class="el-icon-setting"></i>系统项设置</template>
          <el-menu-item index="/dict">数据字典</el-menu-item>
          <el-menu-item index="/countries">国家或地区</el-menu-item>
          <el-menu-item index="4-3">行政区划</el-menu-item>
        </el-submenu>
      </el-menu>
    </el-col>
    <el-col :span="20">
      <router-view></router-view>
    </el-col>
  </el-row>
</template>
<script>
  export default {
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
    }
  };
</script>


<!--
<ul id="main-nav" class="nav nav-tabs nav-stacked">
<li class="active">
  <a href="#">
    <i class="glyphicon glyphicon-th-large"></i> 首页
  </a>
</li>
<li>
  <a href="#org-setting" class="nav-header collapsed" data-toggle="collapse">
    <i class="glyphicon glyphicon-cog"></i> 组织机构
    <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
  </a>
  <ul id="org-setting" class="nav nav-list collapse secondmenu" style="height: 0px;">
    <li class="active"><a href="#"><i class="glyphicon glyphicon-user"></i> 用户管理</a></li>
    <li><a href="#"><i class="glyphicon glyphicon-th-list"></i> 部门管理</a></li>
    <li><a href="#"><i class="glyphicon glyphicon-asterisk"></i> 组织管理</a></li>
  </ul>
</li>
<li>
  <a href="#permission-setting" class="nav-header collapsed" data-toggle="collapse">
    <i class="glyphicon glyphicon-cog"></i> 权限管理
    <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
  </a>
  <ul id="permission-setting" class="nav nav-list collapse second-menu" style="height: 0px;">
    <li><a href="#"><i class="glyphicon glyphicon-user"></i> 角色</a></li>
    <li><a href="#"><i class="glyphicon glyphicon-th-list"></i> 菜单</a></li>
    <li><a href="#"><i class="glyphicon glyphicon-asterisk"></i> 权限</a></li>
  </ul>
</li>
<li>
  <a href="#system-setting" class="nav-header collapsed" data-toggle="collapse">
    <i class="glyphicon glyphicon-cog"></i> 系统项设置
    <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
  </a>
  <ul id="system-setting" class="nav nav-list collapse second-menu" style="height: 0px;">
    <li><a href="#"><i class="glyphicon glyphicon-user"></i> 数据字典</a></li>
    <li><a href="#"><i class="glyphicon glyphicon-th-list"></i> 国家或地区</a></li>
    <li><a href="#"><i class="glyphicon glyphicon-asterisk"></i> 行政区划</a></li>
  </ul>
</li>
</ul>-->
