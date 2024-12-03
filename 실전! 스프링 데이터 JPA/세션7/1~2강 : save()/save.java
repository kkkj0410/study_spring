  @Transactional
  public <S extends T> S save(S entity) {
      Assert.notNull(entity, "Entity must not be null");
      if (this.entityInformation.isNew(entity)) {
          this.entityManager.persist(entity);
          return entity;
      } else {
          return this.entityManager.merge(entity);
      }
  }
