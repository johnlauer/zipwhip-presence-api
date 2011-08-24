package com.zipwhip.signals.presence;

import com.zipwhip.jms.SimpleQueueSender;
import com.zipwhip.signals.address.ChannelAddress;
import com.zipwhip.signals.address.ClientAddress;
import com.zipwhip.signals.address.RemoteAddress;
import com.zipwhip.signals.app.Headers;
import com.zipwhip.signals.message.BasicMessage;
import com.zipwhip.signals.message.DisconnectCommand;
import com.zipwhip.signals.message.JsonMessageSerializerFactory;
import com.zipwhip.signals.message.UnsubscriptionCompleteCommand;

import java.net.InetSocketAddress;

/**
 * Created by IntelliJ IDEA.
 * User: David Davis
 * Date: 7/08/11
 * Time: 11:41 AM
 */
public class DefaultPresenceController implements PresenceController {

    private static final String QUEUE_NAME = "signals.delivery";

    SimpleQueueSender simpleQueueSender;
    JsonMessageSerializerFactory serializer = new JsonMessageSerializerFactory();

    @Override
    public void unsubscribe(ClientAddress clientAddress, ChannelAddress channelAddress) {
        BasicMessage message = new BasicMessage(new Headers(), clientAddress, new UnsubscriptionCompleteCommand(channelAddress.getChannel()));

        simpleQueueSender.sendQueueJMSMessage(QUEUE_NAME, serializer.serialize(message));
    }

    @Override
    public void unsubscribe(ClientAddress clientAddress) {
        /* TODO - will not work yet!

        BasicMessage message = new BasicMessage(new Headers(), clientAddress, new UnsubscriptionCompleteCommand("*"));
        simpleQueueSender.sendQueueJMSMessage(QUEUE_NAME, serializer.serialize(message));
        */
    }

    @Override
    public void disconnect(ClientAddress clientAddress, InetSocketAddress reconnect, Integer delay) {
        DisconnectCommand disconnectCommand = new DisconnectCommand();
        disconnectCommand.setAddress(new RemoteAddress(reconnect));
        if (delay != null) {
            disconnectCommand.setReconnectDelay(delay);
        }

        BasicMessage message = new BasicMessage(new Headers(), clientAddress, disconnectCommand);

        simpleQueueSender.sendQueueJMSMessage(QUEUE_NAME, serializer.serialize(message));
    }

    @Override
    public void disconnect(ClientAddress clientAddress) {
        BasicMessage message = new BasicMessage(new Headers(), clientAddress, new DisconnectCommand());

        simpleQueueSender.sendQueueJMSMessage(QUEUE_NAME, serializer.serialize(message));
    }

    @Override
    public void ban(ClientAddress clientAddress) {
        DisconnectCommand disconnectCommand = new DisconnectCommand();
        disconnectCommand.setBan(true);

        BasicMessage message = new BasicMessage(new Headers(), clientAddress, disconnectCommand);

        simpleQueueSender.sendQueueJMSMessage(QUEUE_NAME, serializer.serialize(message));
    }
}
