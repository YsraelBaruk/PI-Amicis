<?php

namespace App\Http\Controllers\Firebase;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;

class UserContoller extends Controller
{
    public function login(){
        return View('login.index');
    }

    public function home(){
        return View('login.home');
    }

    
}
