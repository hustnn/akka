/**
 * Copyright (C) 2009-2014 Typesafe Inc. <http://www.typesafe.com>
 */

package akka.dispatch;

import akka.util.Unsafe;

final class AbstractMailbox {
    final static long mailboxStatusOffset;
    final static long systemMessageOffset;

    static {
        try {
          mailboxStatusOffset = Unsafe.instance.objectFieldOffset(Mailbox.class.getDeclaredField("_statusDoNotCallMeDirectly"));
          systemMessageOffset = Unsafe.instance.objectFieldOffset(Mailbox.class.getDeclaredField("_systemQueueDoNotCallMeDirectly"));
        } catch(Throwable t){
            throw new ExceptionInInitializerError(t);
        }
    }
}
