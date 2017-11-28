package com.msalcedo.socialma.utils;

import com.msalcedo.socialma.R;
import com.msalcedo.socialma.app.Application;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
public interface Constant {

    interface Location {
        public static final long INTERVAL = 60000;
    }

    interface Key {
        String ACCESS_TOKEN = "access_token";
        String AUTHORIZATION = "Authorization";
        String JWT = "JWT ";
        String BEARER = "Bearer ";

        String ID = "id";
        String ID_STR = "id_str";
        String NAME = "name";

        String USERS = "users";
        String USER_INSTAGRAM = "user_instagram";
        String USER_TWITTER = "user_twitter";
        String USER_ID = "user_id";
        String ME = "me";
        String SESSION = "session";
        String EVENT = "event";
        String CROPPED = "cropped";
        String CLIENT_ID = "client_id";
        String REDIRECT_URI = "redirect_uri";
        String SELF = "self";

        String MEDIA = "media";
        String FOLLOWS = "follows";
        String FOLLOWED_BY = "followed_by";
        String USERNAME = "username";
        String FULL_NAME = "full_name";
        String PROFILE_PICTURE = "profile_picture";
        String BIO = "bio";
        String WEBSITE = "website";
        String COUNTS = "counts";
        String DATA = "data";
        String AUTH = "authInstagram";
    }

    interface Models {

        String AUTH = "authInstagram";
    }

    interface Preferences {
        String APP = "baseAppPreferences";
        String SESSION = "baseAppSessionPreferences";
        String CACHE = "okhttp_cache";
    }

    interface Network {
        interface Status {
            int SUCCESS = 200;
            int CREATED = 201;
            int BAD_REQUEST = 400;
            int UNAUTHORIZED = 401;
            int FORBIDDEN = 403;
            int NOT_FOUND = 404;
            int CONFLICT = 409;
        }
    }

    interface Url {

        String PLAY = "https://play.google.com/store";

        interface Character {
            String BAR = "/";
            String PARAMETER_OPEN = "{";
            String PARAMETER_CLOSE = "}";
            String QUERY = "?";
            String EQUAL = "=";
            String OTHER_QUERY = "&";
        }

        interface Instagram {
            String BASE = "https://api.instagram.com";
            String REDIRECT_URI = "http://nucleos.io/";
            String AUTH = BASE + "/oauth/authorize/?response_type=token" + Character.OTHER_QUERY +
                    Key.REDIRECT_URI + Character.EQUAL + REDIRECT_URI +
                    Character.OTHER_QUERY + Key.CLIENT_ID + Character.EQUAL + Application.component
                    .resources().getString(R.string.INSTAGRAM_CONSUMER_KEY);
            String REDIRECT_URI_TOKEN = REDIRECT_URI + "#access_token=";
            String VERSION = "v1";

            interface User {
                String BASE = Instagram.BASE + Character.BAR + Instagram.VERSION + Character.BAR +
                        Key.USERS + Character.BAR + Key.SELF + Character.BAR;
                String MEDIA_RECENT = BASE + "media/recent/";
            }
        }

        interface Auth {
            String BASE = Character.BAR + Models.AUTH;
        }

        interface Twitter {

            interface User {
                String FROM_ID = "/1.1/users/show.json";
            }
        }
    }

}
