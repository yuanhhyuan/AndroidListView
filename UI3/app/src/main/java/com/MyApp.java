/**
 * Copyright 2017 Sun Jian
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com;

import android.app.Activity;
import android.app.Application;

import java.util.HashSet;
import java.util.Set;

/**

 */
public class MyApp extends Application {

    private static MyApp sInstance;

    //管理所有Activity共享全部变量
    private String myState;
    //管理Activity
    private Set<Activity> mActivities;


    //单例模式
    public static synchronized MyApp getInstance() {
        return sInstance;
    }

    public String getState(){
        return myState;
    }
    public void setState(String s){
        myState = s;
    }


    public void addActivity(Activity activity) {
        if (mActivities == null) {
            mActivities = new HashSet<Activity>();
        }
        mActivities.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (mActivities != null) {
            mActivities.remove(activity);
        }
    }

    public void exitApp() {
        if (mActivities != null) {
            synchronized (this) {
//                mActivities.forEach(Activity::finish);
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}


/**
 应用场景：

 在Android中，可以通过继承Application类来实现应用程序级的全局变量，这种全局变量方法相对静态类更有保障，直到应用的所有Activity全部被destory掉之后才会被释放掉。
 */ 