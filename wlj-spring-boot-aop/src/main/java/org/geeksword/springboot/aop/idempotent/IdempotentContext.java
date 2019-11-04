package org.geeksword.springboot.aop.idempotent;

public enum  IdempotentContext {

    PATH_AND_PARAMS{
        public IdempotentStrategy strategy(){
            return new PathAndParamsStrategy();
        }
    },

    PATH{
      public IdempotentStrategy strategy(){
          return new PathStrategy();
      }
    };

    public IdempotentStrategy strategy(){
        throw new AbstractMethodError();
    }

}
