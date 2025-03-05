@Target(ElementType.TYPE)
//RUNTIME 시점까지 1개의 어노테이션이 살아있도록 유지시킴
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassAop {
}
