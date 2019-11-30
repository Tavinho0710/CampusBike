package com.greenbelly.metraz.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTrava is a Querydsl query type for Trava
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTrava extends EntityPathBase<Trava> {

    private static final long serialVersionUID = 973055288L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTrava trava = new QTrava("trava");

    public final QBike bike;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> numeroTrava = createNumber("numeroTrava", Integer.class);

    public final BooleanPath travaFechada = createBoolean("travaFechada");

    public QTrava(String variable) {
        this(Trava.class, forVariable(variable), INITS);
    }

    public QTrava(Path<? extends Trava> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTrava(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTrava(PathMetadata metadata, PathInits inits) {
        this(Trava.class, metadata, inits);
    }

    public QTrava(Class<? extends Trava> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.bike = inits.isInitialized("bike") ? new QBike(forProperty("bike"), inits.get("bike")) : null;
    }

}

