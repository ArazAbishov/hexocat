package com.abishov.hexocat.github;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class User {

  private static final String LOGIN = "login";
  private static final String HTML_URL = "html_url";
  private static final String AVATAR_URL = "avatar_url";

  public static User create(String login,
      String htmlUrl, String avatarUrl) {
    return new AutoValue_User(login, htmlUrl, avatarUrl);
  }

  public static TypeAdapter<User> typeAdapter(Gson gson) {
    return new AutoValue_User.GsonTypeAdapter(gson);
  }

  @SerializedName(LOGIN)
  public abstract String login();

  @SerializedName(HTML_URL)
  public abstract String htmlUrl();

  @SerializedName(AVATAR_URL)
  public abstract String avatarUrl();
}
