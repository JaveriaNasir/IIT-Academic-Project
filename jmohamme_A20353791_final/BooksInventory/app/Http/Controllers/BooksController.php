<?php

namespace App\Http\Controllers;

use App\Book;
use Illuminate\Http\Request;

use App\Http\Requests;
use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\Session;
use Illuminate\Support\Facades\View;

class BooksController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        session_start();
        if(isset($_SESSION['user'])){
            $books = Book::all();
            return View::make('Books.index')->with('books', $books);
        }
        else{
            $path = "../public/";
            return View::make('Books.login')->with('path',$path);
        }


    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        session_start();
        if(isset($_SESSION['user'])) {
            $path = "../../public/";
            //return view('Books.create');
            return View::make('Books.create')->with('path', $path);
        }
        else{
            $path = "../public/";
            return View::make('Books.login')->with('path',$path);
        }
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $this->validate($request, [
            'isbn' => 'required',
            'title' => 'required',
            'author' => 'required',
            'publisher' => 'required',
            'language' => 'required',
        ]);
        $input = $request->all();
        Book::create($input);
        Session::flash('flash_message', 'Book successfully added!');
        return redirect()->back();
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        session_start();
        if(isset($_SESSION['user'])) {
            $path = "../../public/";
            $book = Book::findOrFail($id);
            return View::make('Books.show')->with('book', $book)->with('path', $path);
        }
        else{
            $path = "../public/";
            return View::make('Books.login')->with('path',$path);
        }

    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        session_start();
        if(isset($_SESSION['user'])) {
            $book = Book::findOrFail($id);
            $path = "../../../public/";

            return View::make('Books.edit')->with('book', $book)->with('path', $path);
        }

        else{
            $path = "../public/";
            return View::make('Books.login')->with('path',$path);
        }
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $book = Book::findOrFail($id);

        $this->validate($request, [
            'isbn' => 'required',
            'title' => 'required',
            'author' => 'required',
            'publisher' => 'required',
            'language' => 'required'
        ]);

        $input = $request->all();

        $book->fill($input)->save();

        Session::flash('flash_message', 'Book successfully updated!');

        return redirect()->back();
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $book = Book::findOrFail($id);

        $book->delete();

        //Session::flash('flash_message', 'Task successfully deleted!');

        return redirect()->route('Books.index');
    }

    public function login()
    {
        $path = "../public/";
        return View::make('Books.login')->with('path',$path);
    }

    public function login_check(Request $request)
    {
        $this->validate($request,
            [
                'username' => 'required',
                'password' => 'required'
            ]);

        $username = $request->username;
        $password = $request->password;
        $valid_user = "admin";
        $valid_hash = '$2y$10$tvKXv57wFWSeECg2ALkh3uQE.F6z7cSjQT/A.3CzfHIVYQtp2/YFe';

        if ($username == $valid_user && password_verify($password, $valid_hash)) {
            session_start();
            $_SESSION['user'] = $valid_user;
            $books = Book::all();
            return View::make('Books.index')->with('books',$books);
        }
        else{
            $path = "../public/";
            return View::make('Books.login')->with('path',$path);
        }
//
    }

    public function logout()
    {
        session_start();
        session_destroy();
        $_SESSION['user'] = null;
        $path = "../public/";
        return View::make('Books.login')->with('path',$path);
    }

}
