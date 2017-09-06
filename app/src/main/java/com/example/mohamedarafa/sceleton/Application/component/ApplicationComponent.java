package com.example.mohamedarafa.sceleton.Application.component;

import com.example.mohamedarafa.sceleton.Application.module.ApiServiceModule;
import com.example.mohamedarafa.sceleton.Application.module.PicassoModule;
import com.example.mohamedarafa.sceleton.Application.scope.ApplicationScope;
import com.example.mohamedarafa.sceleton.service.ApiService;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by mohamed.arafa on 8/27/2017.
 */

@ApplicationScope
@Component(modules = {ApiServiceModule.class, PicassoModule.class})
public interface ApplicationComponent {

    Picasso getPicasso();

    ApiService getService();

}
