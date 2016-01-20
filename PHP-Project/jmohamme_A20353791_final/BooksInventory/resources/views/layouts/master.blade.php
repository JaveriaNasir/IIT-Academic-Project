<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Books</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>

<?php if(isset($path)): ?>
    <body background="{{$path}}Library_boos.jpg" style="background-repeat: no-repeat;background-size: 1300px 700px"; >
<?php else: ?>
<body background="Library_boos.jpg" style="background-repeat: no-repeat;background-size: 1300px 700px"; >
<?php endif; ?>
<div class="page-header" style="border-bottom:none"></div>
<div class ="container" style="width: 900px;">
    <div class="nav navbar-nav navbar-right " style="padding-right: 50px;">
        <li><a href="{{ route('home') }}"><strong style="font-size: 18px; color: #751F1F">Home</strong></a></li>
        <?php if(!isset($_SESSION['user'])) { ?>
        <li><a href="{{ route('login') }}" style="font-size: 18px;color: #843534";><strong>Login</strong></a></li>
        <?php } else { ?>
        <li><a href="{{ route('logout') }}" style="font-size: 18px;color: #843534";><strong>Logout</strong></a></li>
        <?php } ?>
    </div>

    <div class="jumbotron" style="background-color:	#FFE4B5">

<main>
    <div class="container">
        @if(Session::has('flash_message'))
            <div class="alert alert-success">
                {{ Session::get('flash_message') }}
            </div>
        @endif
        @yield('content')
    </div>
</main>
</div>
    </div>
</body>
</body>
</html>
