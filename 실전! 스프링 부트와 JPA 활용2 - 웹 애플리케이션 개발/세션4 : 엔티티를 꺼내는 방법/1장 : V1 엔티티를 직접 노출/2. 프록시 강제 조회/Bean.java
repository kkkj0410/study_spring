@Bean
Hibernate5Module hibernate5Module(){
	Hibernate5Module hibernate5Module = new Hibernate5Module();
	hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, true);
	return hibernate5Module;
}

@Bean
Hibernate5Module hibernate5Module(){
	return new Hibernate5Module();
}
