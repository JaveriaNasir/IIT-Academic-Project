@extends('layouts.master')

@section('content')

    <h1>Welcome Home</h1>
    <hr>

    <a href="{{ route('Books.index') }}" class="btn btn-info">View Books</a>
    <a href="{{ route('Books.create') }}" class="btn btn-primary">Add New Book</a>

@stop