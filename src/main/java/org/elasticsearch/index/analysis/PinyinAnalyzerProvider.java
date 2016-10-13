package org.elasticsearch.index.analysis;

import org.elasticsearch.analysis.PinyinConfig;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.settings.IndexSettingsService;
/**
 */
public class PinyinAnalyzerProvider extends AbstractIndexAnalyzerProvider<PinyinAnalyzer> {

    private final PinyinAnalyzer analyzer;
    private PinyinConfig config;

    @Inject
    public PinyinAnalyzerProvider(Index index, IndexSettingsService indexSettings, Environment env, @Assisted String name, @Assisted Settings settings) {
        super(index, indexSettings.getSettings(), name, settings);
        config=new PinyinConfig(settings);
        analyzer = new PinyinAnalyzer(config);
    }

    @Override
    public PinyinAnalyzer get() {
        return this.analyzer;
    }
}
