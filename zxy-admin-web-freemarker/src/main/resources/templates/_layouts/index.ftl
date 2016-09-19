<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>用户中心</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <link rel="stylesheet" href="//cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.min.css">
  <link rel="stylesheet" href="//cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
  <link rel="stylesheet" href="libs/adminlte/css/AdminLTE.min.css">
  <link rel="stylesheet" href="libs/adminlte/css/skins/skin-blue.min.css">
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="/" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>A</b>LT</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Admin</b>LTE</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">           
           <li class="dropdown user user-menu">
	            <a href="#" class="dropdown-toggle">
	              <img src="../../dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
	              <span class="hidden-xs">administrator</span>
	            </a>    
		   </li>
           <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> 退出</a></li>
        </ul>
      </div>
    </nav>
  </header>
  
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar Menu -->
      <ul class="sidebar-menu">
        <li class="header">菜单</li>
        <li class="treeview active">
         <a href="#">
           <i class="fa fa-files-o"></i>
           <span>组织机构</span>
         </a>    
         <ul class="treeview-menu">
           <li data-url="users/index" class="active" ><a href="javascript:void(0)"><i class="fa fa-circle-o"></i> 人员</a></li>
           <li data-url="depts/index"><a href="javascript:void(0)"><i class="fa fa-circle-o"></i> 部门</a></li>
           <li data-url="orgs/index"><a href="javascript:void(0)"><i class="fa fa-circle-o"></i> 组织</a></li>
         </ul>
       </li>
       <li class="treeview">
         <a href="#">
         	<i class="fa fa-files-o"></i>
         	<span>权限管理</span>
         </a>
         <ul class="treeview-menu">
         	<li><a href="boxed.html"><i class="fa fa-circle-o"></i> 角色</a></li>
         	<li><a href="boxed.html"><i class="fa fa-circle-o"></i> 菜单</a></li>
         	<li><a href="boxed.html"><i class="fa fa-circle-o"></i> 权限</a></li>
         </ul>
       </li>
       <li class="treeview">
         <a href="#">
         	<i class="fa fa-files-o"></i>
         	<span>系统项设置</span>
         </a>
         <ul class="treeview-menu">
         	<li data-url="dictionary/index"><a href="javascript:void(0)"><i class="fa fa-circle-o"></i> 数据字典</a></li>
         	<li data-url="countries/index"><a href="javascript:void(0)"><i class="fa fa-circle-o"></i> 国家或地区</a></li>
         	<li data-url="areas/index"><a href="javascript:void(0)"><i class="fa fa-circle-o"></i> 行政区划</a></li>
         </ul>
       </li>
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">  
    <!-- Main content -->
      <div class="embed-responsive  embed-responsive-16by9" id="iFrameContainer">
          <iframe class="embed-responsive-item" id="contentIFrame"></iframe>
      </div>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<script src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="libs/adminlte/js/app.min.js"></script>
<script type="text/javascript">
  $(function () {
      $('.treeview-menu > li').click(function () {
          $(this).addClass('active').siblings().removeClass('active');
      });
      $('.sidebar-menu li').click(function () {
          var url = $(this).data('url');
          if (url != undefined && url.length > 0) {
              $('#contentIFrame').attr('src', url);
              return false;
          }
      });
        
      function _fix() {
          var h = $(window).height();
          $("#iFrameContainer").css({
              height: (h - 50) + "px"
          });
      }
      _fix();
      $(window).resize(function() {
          _fix();
      });
  });
  </script>
</body>
</html>