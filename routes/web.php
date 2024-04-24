<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\Firebase\UserContoller;

Route::get('login', [UserContoller::class, 'login'])->name('login.index');

Route::get('/', [UserContoller::class, 'home'])->name('login.home');
