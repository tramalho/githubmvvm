package br.com.tramalho.githubmvvm;

import android.app.Application;

import br.com.tramalho.githubmvvm.di.ComponentBuilder;

/**
 * Created by trama on 18/03/18.
 */

public class CustomApplicationImpl extends Application implements CustomApplication {

    public ComponentBuilder builder() {
        return new ComponentBuilder();
    }
}
