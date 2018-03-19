package br.com.tramalho.githubmvvm.testutilities;

import br.com.tramalho.githubmvvm.CustomApplication;
import br.com.tramalho.githubmvvm.CustomApplicationImpl;
import br.com.tramalho.githubmvvm.di.ComponentBuilder;
import br.com.tramalho.githubmvvm.di.MockComponentBuilder;

/**
 * Created by trama on 19/03/18.
 */

public class CustomMockApplication extends CustomApplicationImpl implements CustomApplication {

    public ComponentBuilder builder() {
        return new MockComponentBuilder();
    }
}
