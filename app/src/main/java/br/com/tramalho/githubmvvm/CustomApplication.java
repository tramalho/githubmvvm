package br.com.tramalho.githubmvvm;

import android.app.Application;

import br.com.tramalho.githubmvvm.di.ComponentBuilder;

/**
 * Created by trama on 18/03/18.
 */

public class CustomApplication extends Application {

    public static ComponentBuilder builder() {
        return new ComponentBuilder();
    }
}
