<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the controller to call when that URI is requested.
|
*/

/*Route::get('/', function () {
    return view('welcome');
});*/

Route::get('/', [
    'as' => 'home',
    'uses' => 'BooksController@index'
]);

Route::resource('Books', 'BooksController');

Route::get('index', function () {
    return view('Books.index');
});

Route::post('Valid','BooksController@login_check');
Route::get('logout', [
    'as' => 'logout',
    'uses' => 'BooksController@logout'
]);


Route::get('login', [
    'as' => 'login',
    'uses' => 'BooksController@login'
]);

