package br.com.techchalleng4.mslogistica.job.processor;

import br.com.techchalleng4.mslogistica.model.Carrier;
import org.springframework.batch.item.ItemProcessor;

public class LoadCarriersProcessor implements ItemProcessor<Carrier, Carrier> {

    @Override
    public Carrier process(Carrier item) throws Exception {
        return item;
    }
}
