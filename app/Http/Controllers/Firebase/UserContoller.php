<?php

namespace App\Http\Controllers\Firebase;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Kreait\Firebase\Contract\Firestore;

class UserContoller extends Controller
{
    public function __construct(Firestore $firestore)
    {
        $this->firestore = $firestore;
    }

    public function login(){
        return View('login.index');
    }

    public function home(){
        return View('login.home');
    }

    public function createAccount(Request $request){
        $postData = [
            'firstName' => $request->first_name,
            'email' => $request->email,
            'phone' => $request->phone,
            'password' => $request->password,
        ];
        $postRef = $database->getReference('posts')->push($postData);
    }
}
