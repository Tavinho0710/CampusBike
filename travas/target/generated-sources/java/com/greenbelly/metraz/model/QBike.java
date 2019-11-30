package com.greenbelly.metraz.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBike is a Querydsl query type for Bike
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBike extends EntityPathBase<Bike> {

    private static final long serialVersionUID = -107703049L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBike bike = new QBike("bike");

    public final NumberPath<Long> codigo = createNumber("codigo", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QUser user;

    public QBike(String variable) {
        this(Bike.class, forVariable(variable), INITS);
    }

    public QBike(Path<? extends Bike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBike(PathMetadata metadata, PathInits inits) {
        this(Bike.class, metadata, inits);
    }

    public QBike(Class<? extends Bike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

