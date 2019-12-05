package com.example.learn_singleton;

class SingletonClass {
    private static volatile SingletonClass instance;

    //private constructor.
    private SingletonClass() {
        if (instance != null) {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class.");
        }
    }

    static SingletonClass getInstance() {
        if (instance == null) {
            //if there is no instance available... create new one
            synchronized (SingletonClass.class) {   //Check for the second time.
                //if there is no instance available... create new one
                if (instance == null) instance = new SingletonClass();
            }
            //  instance = new LazyInitializedSingletonExample();
        }

        return instance;
    }
}
