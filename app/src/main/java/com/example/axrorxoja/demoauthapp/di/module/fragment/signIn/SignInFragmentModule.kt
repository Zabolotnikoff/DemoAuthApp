package com.example.axrorxoja.demoauthapp.di.module.fragment.signIn

import com.example.axrorxoja.demoauthapp.di.scope.signIn.SignInFragmentScope
import com.example.axrorxoja.demoauthapp.model.repository.ApiService
import com.example.axrorxoja.demoauthapp.model.repository.signIn.ISignInRepository
import com.example.axrorxoja.demoauthapp.model.repository.signIn.SignInRepositoryImpl
import com.example.axrorxoja.demoauthapp.presentation.signIn.IPresenterSignIn
import com.example.axrorxoja.demoauthapp.presentation.signIn.IViewSignIn
import com.example.axrorxoja.demoauthapp.presentation.signIn.SignInPresenterImpl
import com.example.axrorxoja.demoauthapp.ui.fragments.SignInFragment
import com.example.axrorxoja.demoauthapp.widget.connectionManager.IConnectionManager
import dagger.Module
import dagger.Provides

/*
* Created by axrorxoja on 9/27/18
*/
@Module
class SignInFragmentModule {

    @Provides
    @SignInFragmentScope
    fun provideRepository(service: ApiService): ISignInRepository = SignInRepositoryImpl(service)

    @Provides
    @SignInFragmentScope
    fun provideView(fragment: SignInFragment): IViewSignIn = fragment

    @Provides
    @SignInFragmentScope
    fun providePresenter(
        repo: ISignInRepository,
        view: IViewSignIn,
        connection: IConnectionManager
    ): IPresenterSignIn =
        SignInPresenterImpl(repo, view, connection)
}