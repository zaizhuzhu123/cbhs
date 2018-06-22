package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsMessage is a Querydsl query type for CbhsMessage
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsMessage extends EntityPathBase<CbhsMessage> {

    private static final long serialVersionUID = -1287408725L;

    public static final QCbhsMessage cbhsMessage = new QCbhsMessage("cbhsMessage");

    public final BooleanPath alreadyRead = createBoolean("alreadyRead");

    public final NumberPath<Integer> examinerOid = createNumber("examinerOid", Integer.class);

    public final StringPath extStr = createString("extStr");

    public final StringPath message = createString("message");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Integer> personOid = createNumber("personOid", Integer.class);

    public final NumberPath<Long> time = createNumber("time", Long.class);

    public final StringPath timeStr = createString("timeStr");

    public final StringPath title = createString("title");

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public QCbhsMessage(String variable) {
        super(CbhsMessage.class, forVariable(variable));
    }

    public QCbhsMessage(Path<? extends CbhsMessage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsMessage(PathMetadata metadata) {
        super(CbhsMessage.class, metadata);
    }

}

