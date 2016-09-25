<#macro header title="用户中心">
	<#assign theScript>
		<#nested />
	</#assign>
	<#assign theTitle>${title}</#assign>
</#macro>
<#macro body>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>${theTitle}</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <script src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
  <!-- bootstrap -->
  <link  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous" rel="stylesheet">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  <!-- font-awesome -->
  <link rel="stylesheet" href="//cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.min.css">
  <link rel="stylesheet" href="//cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">    
  <!-- jquery ui -->
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js" integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU=" crossorigin="anonymous"></script>
  <!-- AdminLTE -->
  <link rel="stylesheet" href="/libs/adminlte/css/AdminLTE.min.css">
  <link rel="stylesheet" href="/libs/adminlte/css/skins/skin-blue.min.css">
  <script src="/libs/adminlte/js/app.min.js"></script>
  <script src="/libs/namespace.js"></script>
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  ${theScript}
  <style type="text/css">
    .dataTables_length{
  		padding-top: 0.7em;
  	}
  </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
   <#nested />
</body>
</html>
</#macro>