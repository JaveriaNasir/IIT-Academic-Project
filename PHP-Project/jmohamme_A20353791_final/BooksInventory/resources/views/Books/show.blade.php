@extends('layouts.master')

@section('content')
    <h2 style="color: #751F1F">Edit Book</h2>

    <table class="table table-hover">
        <tr>
            <td style="border-top: 1px solid #751F1F"><Strong style="font-size: 18px; color: #751F1F"> Isbn :</Strong></td>
            <td style="border-top: 1px solid #751F1F"><span style="font-size: 18px;color: #751F1F">{{ $book->isbn }}</span></td>
        </tr>
        <tr>
            <td style="border-top: 1px solid #751F1F"><Strong style="font-size: 18px;color: #751F1F">Title : </Strong></td>
            <td style="border-top: 1px solid #751F1F"><span style="font-size: 18px;color: #751F1F">{{ $book->title }}</span></td>
        </tr>
        <tr>
            <td style="border-top: 1px solid #751F1F"><Strong style="font-size: 18px;color: #751F1F">Author :</Strong></td>
            <td style="border-top: 1px solid #751F1F"><span style="font-size: 18px;color: #751F1F">{{ $book->author }}</span></td>
        </tr>
        <tr>
            <td style="border-top: 1px solid #751F1F"><Strong style="font-size: 18px;color: #751F1F">Publisher :</Strong></td>
            <td style="border-top: 1px solid #751F1F"><span style="font-size: 18px;color: #751F1F">{{ $book->publisher }}</span></td>
        </tr>
        <tr>
            <td style="border-top: 1px solid #751F1F"><Strong style="font-size: 18px;color: #751F1F">Language :</Strong></td>
            <td style="border-top: 1px solid #751F1F"><span style="font-size: 18px;color: #751F1F">{{ $book->language }}</span></td>
        </tr>
    </table>
    <!--<h1>{{ $book->isbn }}</h1>
    <p class="lead">{{ $book->title }}</p>
    <p class="lead">{{ $book->author }}</p>
    <p class="lead">{{ $book->publisher }}</p>
    <p class="lead">{{ $book->language }}</p>-->


    <div class="row">
        <div class="col-md-6">
    <a href="{{ route('Books.index') }}" class="btn btn-primary" style="border-color: #8B4513; background-color: #8B4513">Back to all Books</a>&nbsp;&nbsp;&nbsp;
    <a href="{{ route('Books.edit', $book->id) }}" class="btn btn-primary" style="border-color: #8B4513; background-color: #8B4513">Edit Book</a>
        </div>
        <div class="col-md-6 text-right">
            {!! Form::open([
                  'method' => 'DELETE',
                  'route' => ['Books.destroy', $book->id]
              ]) !!}
            {!! Form::submit('Delete Book', ['class' => 'btn btn-danger']) !!}
            {!! Form::close() !!}
        </div>
    </div>

@stop