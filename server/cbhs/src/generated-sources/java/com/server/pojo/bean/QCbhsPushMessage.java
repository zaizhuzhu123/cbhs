package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsPushMessage is a Querydsl query type for CbhsPushMessage
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsPushMessage extends EntityPathBase<CbhsPushMessage> {

    private static final long serialVersionUID = -1513563855L;

    public static final QCbhsPushMessage cbhsPushMessage = new QCbhsPushMessage("cbhsPushMessage");

    public final StringPath alert = createString("alert");

    public final NumberPath<Integer> examinerOid = createNumber("examinerOid", Integer.class);

    public final StringPath extStr = createString("extStr");

    public final StringPath message = createString("message");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Integer> personOid = createNumber("personOid", Integer.class);

    public final StringPath pushedStr = createString("pushedStr");

    public final NumberPath<Long> pushedTime = createNumber("pushedTime", Long.class);

    public final BooleanPath state = createBoolean("state");

    public final NumberPath<Long> time = createNumber("time", Long.class);

    public final StringPath timeStr = createString("timeStr");

    public final StringPath title = createString("title");

    public QCbhsPushMessage(String variable) {
        super(CbhsPushMessage.class, forVariable(variable));
    }

    public QCbhsPushMessage(Path<? extends CbhsPushMessage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsPushMessage(PathMetadata metadata) {
        super(CbhsPushMessage.class, metadata);
    }

}

