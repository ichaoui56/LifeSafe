package org.example.lifesafe.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.lifesafe.repository.DefaultRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class DefaultRepositoryImpl<Entity> implements DefaultRepository<Entity> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<Entity> entityType;

    public DefaultRepositoryImpl(Class<Entity> entityType) {
        this.entityType = entityType;
    }

    @Override
    @Transactional
    public boolean create(Entity entity) {
        try {
            entityManager.persist(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    @Transactional
    public boolean update(Entity entity) {
        try {
            entityManager.merge(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    @Transactional
    public boolean delete(Entity entity) {
        try {
            Entity managedEntity = entityManager.contains(entity) ? entity : entityManager.merge(entity);
            entityManager.remove(managedEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Entity> findById(Long id) {
        try {
            Entity entity = entityManager.find(entityType, id);
            return Optional.ofNullable(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Entity> findAll() {
        try {
            return entityManager.createQuery("SELECT e FROM " + entityType.getSimpleName() + " e", entityType)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
