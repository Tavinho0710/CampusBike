package com.greenbelly.metraz.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocacao is a Querydsl query type for Locacao
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLocacao extends EntityPathBase<Locacao> {

    private static final long serialVersionUID = 208505402L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocacao locacao = new QLocacao("locacao");

    public final QBike bike;

    public final DateTimePath<java.util.Date> dataDevolucao = createDateTime("dataDevolucao", java.util.Date.class);

    public final DateTimePath<java.util.Date> dataLocacao = createDateTime("dataLocacao", java.util.Date.class);

    public final BooleanPath emAberto = createBoolean("emAberto");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QTrava travaDevolucao;

    public final QTrava travaRetirada;

    public final QUser usuario;

    public QLocacao(String variable) {
        this(Locacao.class, forVariable(variable), INITS);
    }

    public QLocacao(Path<? extends Locacao> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLocacao(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLocacao(PathMetadata metadata, PathInits inits) {
        this(Locacao.class, metadata, inits);
    }

    public QLocacao(Class<? extends Locacao> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.bike = inits.isInitialized("bike") ? new QBike(forProperty("bike"), inits.get("bike")) : null;
        this.travaDevolucao = inits.isInitialized("travaDevolucao") ? new QTrava(forProperty("travaDevolucao"), inits.get("travaDevolucao")) : null;
        this.travaRetirada = inits.isInitialized("travaRetirada") ? new QTrava(forProperty("travaRetirada"), inits.get("travaRetirada")) : null;
        this.usuario = inits.isInitialized("usuario") ? new QUser(forProperty("usuario")) : null;
    }

}

