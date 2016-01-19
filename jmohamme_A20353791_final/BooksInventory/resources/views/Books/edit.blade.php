@extends('layouts.master')

@section('content')

    <h2 style="color: #751F1F">Edit Book</h2>
   <hr style=  "display: block;height: 2px;border: 0;border-top: 2px solid #751F1F;margin: 1em 0;padding: 0";>
    @if($errors->any())
        <div class="alert alert-danger">
            @foreach($errors->all() as $error)
                <p>{{ $error }}</p>
            @endforeach
        </div>
    @endif
    {!! Form::model($book, [
    'method' => 'PATCH',
    'route' => ['Books.update', $book->id]
]) !!}

    <div class="form-group">
        {!! Form::label('isbn', 'Isbn:', ['class' => 'control-label','style'=>'color: #751F1F']) !!}
        {!! Form::text('isbn', null, ['class' => 'form-control']) !!}
    </div>

    <div class="form-group">
        {!! Form::label('title', 'Title:', ['class' => 'control-label','style'=>'color: #751F1F']) !!}
        {!! Form::text('title', null, ['class' => 'form-control']) !!}
    </div>

    <div class="form-group">
        {!! Form::label('author', 'Author:', ['class' => 'control-label','style'=>'color: #751F1F']) !!}
        {!! Form::text('author', null, ['class' => 'form-control']) !!}
    </div>

    <div class="form-group">
        {!! Form::label('publisher', 'Publisher:', ['class' => 'control-label','style'=>'color: #751F1F']) !!}
        {!! Form::text('publisher', null, ['class' => 'form-control']) !!}
    </div>

    <div class="form-group">
        {!! Form::label('language', 'Language:', ['class' => 'control-label','style'=>'color: #751F1F']) !!}
        {!! Form::text('language', null, ['class' => 'form-control']) !!}
    </div>

    {!! Form::submit('Update Book', ['class' => 'btn btn-primary','style'=>'border-color: #8B4513; background-color: #8B4513'])  !!}&nbsp;&nbsp;&nbsp;
    <a href="{{ route('Books.index')}}" class="btn btn-info" role="button" style="border-color: #8B4513; background-color: #8B4513">Cancel</a>


    {!! Form::close() !!}

@stop