@extends('layouts.master')

@section('content')

    <h2 style="color: #751F1F">Book List</h2>
    <p class="lead" style="color: #751F1F">Here's a list of all your Books. <a href="{{ route('Books.create') }}" class="btn btn-info" role="button" style="border-color: #8B4513; background-color: #8B4513">Add a new one</a></p>

    <table class="table  table-bordered table-condensed"; data-toggle="table">
        <tr>
            <th style="border: 1px solid #751F1F"><span STYLE="strong; color: brown;text-decoration: underline" >Isbn </span></th>
            <th style="border: 1px solid #751F1F"><span STYLE="strong; color: brown;text-decoration: underline">Title</span></th>
            <th style="border: 1px solid #751F1F"><span STYLE="strong; color: brown;text-decoration: underline;">Author</span></th>
            <th style="border: 1px solid #751F1F"><span STYLE="strong; color: brown;text-decoration: underline;">Publisher</span></th>
            <th style="border: 1px solid #751F1F"><span STYLE="strong; color: brown;text-decoration: underline;">Language</span></th>
            <th style="border: 1px solid #751F1F"><span STYLE="strong; color: brown;text-decoration: underline;">View</span></th>
            <th style="border: 1px solid #751F1F"><span STYLE="strong; color: brown;text-decoration: underline;">Edit</span></th>
        </tr>

    @foreach($books as $book)
            <tr>
             <td style="border: 1px solid #751F1F"><span STYLE="color: black;font-size: small" >{{$book->isbn}}</span></td>
             <td style="border: 1px solid #751F1F"><span STYLE="color: black;font-size: small" >{{ $book->title }}</span></td>
             <td style="border: 1px solid #751F1F"><span STYLE="color: black;font-size: small" >{{$book->author}}</span></td>
             <td style="border: 1px solid #751F1F"><span STYLE="color: black;font-size: small" >{{$book->publisher}}</span></td>
             <td style="border: 1px solid #751F1F"><span STYLE="color: black;font-size: small" >{{$book->language}}</span></td>

        <td style="border: 1px solid #751F1F"><a href="{{ route('Books.show', $book->id) }}" class="btn btn-info" role="button" style="border-color: #8B4513; background-color: #8B4513">View</a></td>
                <td style="border: 1px solid #751F1F"><a href="{{ route('Books.edit', $book->id) }}" class="btn btn-info" role="button" style="border-color: #8B4513; background-color: #8B4513">Edit</a></td>
            </tr>


    @endforeach
    </table>



@stop