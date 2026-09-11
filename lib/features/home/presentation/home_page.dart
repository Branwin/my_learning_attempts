import 'package:flutter/material.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: ListView(
        padding: const EdgeInsets.fromLTRB(20, 24, 20, 24),
        children: [
          Text(
            '今天也要保持学习',
            style: Theme.of(context).textTheme.headlineSmall?.copyWith(
                  fontWeight: FontWeight.bold,
                ),
          ),
          const SizedBox(height: 6),
          Text(
            '把灵感变成可以复习的知识点。',
            style: Theme.of(context).textTheme.bodyMedium,
          ),
          const SizedBox(height: 20),
          const TextField(
            decoration: InputDecoration(
              hintText: '搜索知识点标题',
              prefixIcon: Icon(Icons.search),
              suffixIcon: Icon(Icons.tune),
            ),
          ),
          const SizedBox(height: 28),
          _SectionHeader(title: '每日推荐', actionLabel: '换一批'),
          const SizedBox(height: 12),
          const _RecommendationCard(),
          const SizedBox(height: 28),
          _SectionHeader(title: '今日计划', actionLabel: '查看全部'),
          const SizedBox(height: 12),
          const _PlanItem(
            title: '复习数据结构：二叉树',
            subtitle: '计算机基础 · 25 分钟',
            isDone: false,
          ),
          const SizedBox(height: 8),
          const _PlanItem(
            title: '整理英语阅读笔记',
            subtitle: '英语 · 15 分钟',
            isDone: true,
          ),
        ],
      ),
    );
  }
}

class _SectionHeader extends StatelessWidget {
  const _SectionHeader({required this.title, required this.actionLabel});

  final String title;
  final String actionLabel;

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Text(
          title,
          style: Theme.of(context).textTheme.titleLarge?.copyWith(
                fontWeight: FontWeight.bold,
              ),
        ),
        TextButton(onPressed: () {}, child: Text(actionLabel)),
      ],
    );
  }
}

class _RecommendationCard extends StatelessWidget {
  const _RecommendationCard();

  @override
  Widget build(BuildContext context) {
    return Card(
      child: Padding(
        padding: const EdgeInsets.all(20),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Row(
              children: [
                Chip(
                  label: const Text('计算机基础'),
                  backgroundColor:
                      Theme.of(context).colorScheme.primaryContainer,
                  side: BorderSide.none,
                ),
                const Spacer(),
                IconButton(
                  onPressed: () {},
                  icon: const Icon(Icons.bookmark_border),
                  tooltip: '收藏',
                ),
              ],
            ),
            const SizedBox(height: 8),
            Text(
              '理解复杂度：从 Big O 开始',
              style: Theme.of(context).textTheme.titleMedium?.copyWith(
                    fontWeight: FontWeight.bold,
                  ),
            ),
            const SizedBox(height: 8),
            Text(
              '用渐进表示法描述算法的时间与空间开销，建立分析算法效率的基础。',
              style: Theme.of(context).textTheme.bodyMedium,
            ),
            const SizedBox(height: 16),
            FilledButton.tonalIcon(
              onPressed: () {},
              icon: const Icon(Icons.add_task),
              label: const Text('加入今日计划'),
            ),
          ],
        ),
      ),
    );
  }
}

class _PlanItem extends StatelessWidget {
  const _PlanItem({
    required this.title,
    required this.subtitle,
    required this.isDone,
  });

  final String title;
  final String subtitle;
  final bool isDone;

  @override
  Widget build(BuildContext context) {
    return Card(
      child: ListTile(
        leading: Icon(
          isDone ? Icons.check_circle : Icons.radio_button_unchecked,
          color: isDone
              ? Theme.of(context).colorScheme.primary
              : Theme.of(context).colorScheme.outline,
        ),
        title: Text(
          title,
          style: TextStyle(
            decoration: isDone ? TextDecoration.lineThrough : null,
          ),
        ),
        subtitle: Text(subtitle),
        trailing: const Icon(Icons.drag_handle),
      ),
    );
  }
}
